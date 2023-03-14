package com.matera.bootcamp2023.service;

import com.matera.bootcamp2023.domain.Banco;
import com.matera.bootcamp2023.domain.Conta;
import com.matera.bootcamp2023.domain.Titular;
import com.matera.bootcamp2023.dto.ContaRequestDto;
import com.matera.bootcamp2023.dto.PixBacenDto;
import com.matera.bootcamp2023.exceptions.BancoInexistenteException;
import com.matera.bootcamp2023.exceptions.ContaExistenteException;
import com.matera.bootcamp2023.exceptions.ContaInexistenteException;
import com.matera.bootcamp2023.exceptions.OperacaoInvalidaException;
import com.matera.bootcamp2023.repository.BancoRepository;
import com.matera.bootcamp2023.repository.ContaRepository;
import com.matera.bootcamp2023.repository.TitularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TitularRepository titularRepository;

    private final BancoRepository bancoRepository;

    private final PixBacenService pixBacenService;

    public Conta criarConta(ContaRequestDto requestDto) {

        int codigo = requestDto.getCodigo();
        final Banco banco = bancoRepository.findByCodigo(codigo).orElseThrow(() -> new BancoInexistenteException("Banco não encontrado: " + codigo));

        final Titular titular = new Titular();
        titular.setCpf(requestDto.getCpf());
        titular.setNome(requestDto.getNome());
        titularRepository.save(titular);

        var conta = new Conta();
        conta.setAgencia(requestDto.getAgencia());
        conta.setTitular(titular);
        conta.setBanco(banco);
        conta.setPix(requestDto.getChave());
        validaContaExistente(conta);
        Conta contaSalva = contaRepository.save(conta);
        pixBacenService.cadastraPixBancoCentral(contaSalva.toBacenDto());
        return contaSalva;
    }

    private void validaContaExistente(Conta conta) {
        Optional<Conta> contaOptional = contaRepository.findByAgenciaAndNumero(conta.getAgencia(), conta.getNumero());

        if (contaOptional.isPresent()) {
            throw new ContaExistenteException();
        }
    }

    public List<Conta> procuraContas() {
        return contaRepository.findAll();
    }

    public Conta procuraConta(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isEmpty()) {
            throw new ContaInexistenteException("Essa conta não existe!");
        }
        return contaOptional.get();
    }

    public Conta creditarConta(Long idConta, BigDecimal valor) {
        Conta conta = procuraConta(idConta);
        conta.credito(valor);
        return contaRepository.save(conta);
    }

    public Conta debitaConta(Long idConta, BigDecimal valor) {
        Conta conta = procuraConta(idConta);
        conta.debito(valor);
        return contaRepository.save(conta);
    }

    public void transferencia(Long idContaDebitada, Long idContaCreditada, BigDecimal valor) {

        Conta contaDebitada = procuraConta(idContaDebitada);
        Conta contaCreditada = procuraConta(idContaCreditada);

        validarTransferencia(contaDebitada, contaCreditada);

        contaDebitada.debito(valor);
        contaCreditada.credito(valor);
        List<Conta> contas = new ArrayList<>();
        contas.add(contaCreditada);
        contas.add(contaDebitada);
        contaRepository.saveAll(contas);
    }

    private static void validarTransferencia(Conta contaDebitada, Conta contaCreditada) {
        if (contaDebitada.getBanco().getCodigo() != contaCreditada.getBanco().getCodigo()) {
            throw new OperacaoInvalidaException();
        }
    }

    public void pix(Long idContaDebitada, String chavePix, BigDecimal valor) {
        final Conta contaDebitada = procuraConta(idContaDebitada);

        PixBacenDto pixBacenDto = pixBacenService.buscarContaBancoCentral(chavePix);

        Conta contaCreditada = contaRepository.findByAgenciaAndNumero(pixBacenDto.getAgencia(), pixBacenDto.getNumero())
                .orElseThrow(() -> new ContaInexistenteException("Conta não encontrada: " + chavePix));

        contaDebitada.debito(valor);
        contaCreditada.credito(valor);
        List<Conta> contas = new ArrayList<>();
        contas.add(contaCreditada);
        contas.add(contaDebitada);
        contaRepository.saveAll(contas);
    }
}