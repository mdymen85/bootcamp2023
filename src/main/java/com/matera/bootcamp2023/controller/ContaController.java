package com.matera.bootcamp2023.controller;

import com.matera.bootcamp2023.domain.Conta;
import com.matera.bootcamp2023.dto.ContaResponseDto;
import com.matera.bootcamp2023.dto.ContaRequestDto;
import com.matera.bootcamp2023.dto.PixDto;
import com.matera.bootcamp2023.repository.ContaRepository;
import com.matera.bootcamp2023.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/contas")
public class ContaController {

    private final ContaRepository contaRepository;
    private final ContaService contaService;

    @PostMapping
    public ContaResponseDto criarConta(@RequestBody ContaRequestDto requestDto) {
        Conta conta = contaService.criarConta(requestDto);
        return conta.toContaDto();
    }

    @GetMapping()
    public List<Conta> procuraContas() {
        return contaService.procuraContas();
    }

//    @GetMapping("/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ContaDto> procuraContaPorId(@PathVariable Long id) {
//
//        try {
//            Optional<Conta> contaOptional = contaService.procuraConta(id);
//            Conta conta = contaOptional.get();
//            //return ResponseEntity.status(HttpStatus.OK).body(conta.toContaDto());
//            //return ResponseEntity.ok().body(conta.toContaDto());
//            return ResponseEntity.ok(conta.toContaDto());
//        } catch (ContaInexistenteException exception) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaResponseDto> procuraContaPorIdSemTry(@PathVariable Long id) {
        Conta conta = contaService.procuraConta(id);
        return ResponseEntity.ok(conta.toContaDto());
    }

    @PostMapping("/{idConta}/credito/{valor}")
    public ResponseEntity<ContaResponseDto> creditarConta(@PathVariable Long idConta, @PathVariable BigDecimal valor) {
        Conta conta = contaService.creditarConta(idConta, valor);
        return ResponseEntity.ok(conta.toContaDto());
    }

    @PostMapping("/{idConta}/debito/{valor}")
    public ResponseEntity<ContaResponseDto> debitaConta(@PathVariable Long idConta, @PathVariable BigDecimal valor) {
        Conta conta = contaService.debitaConta(idConta, valor);
        return ResponseEntity.ok(conta.toContaDto());
    }


    @PostMapping("/{idContaDebitada}/{idContaCreditada}/{valor}")
    public ResponseEntity debitaConta(@PathVariable Long idContaDebitada, @PathVariable Long idContaCreditada, @PathVariable BigDecimal valor) {
        contaService.transferencia(idContaDebitada, idContaCreditada, valor);
        return ResponseEntity.ok("Transferencia realizada com sucesso");
    }

    @PostMapping("/{idContaDebitada}/{chavePix}")
    public ResponseEntity debitaConta(@PathVariable Long idContaDebitada,
                                      @PathVariable String chavePix,
                                      @RequestBody PixDto pixDto) {
        contaService.pix(idContaDebitada, chavePix, pixDto.getValor());
        return ResponseEntity.ok("Pix realizada com sucesso");
    }
}