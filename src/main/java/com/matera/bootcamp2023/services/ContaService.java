package com.matera.bootcamp2023.service;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.Titular;
import com.matera.bootcamp2023.dto.ContaRequestDto;
import com.matera.bootcamp2023.exceptions.ContaExistenteException;
import com.matera.bootcamp2023.repository.ContaRepository;
import com.matera.bootcamp2023.repository.TitularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TitularRepository titularRepository;

    public Conta criarConta(ContaRequestDto requestDto) {

        final Titular titular = new Titular();
        titular.setCpf(requestDto.getCpf());
        titular.setNome(requestDto.getNome());
        titularRepository.save(titular);

        var conta = new Conta();
        conta.setAgencia(requestDto.getAgencia());
        conta.setTitular(titular);
        validaContaExistente(conta);
        return contaRepository.save(conta);
    }

    private void validaContaExistente(Conta conta) {
        Optional<Conta> contaOptional =
                contaRepository.findByAgenciaAndNumero(conta.getAgencia(), conta.getNumero());

        if (contaOptional.isPresent()) {
            throw new ContaExistenteException();
        }
    }
}