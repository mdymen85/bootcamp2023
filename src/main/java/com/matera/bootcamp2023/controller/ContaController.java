package com.matera.bootcamp2023.controller;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.dto.ContaDto;
import com.matera.bootcamp2023.dto.ContaRequestDto;
import com.matera.bootcamp2023.repository.ContaRepository;
import com.matera.bootcamp2023.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/contas")
public class ContaController {

    private final ContaRepository contaRepository;
    private final ContaService contaService;

    @PostMapping
    public ContaDto criarConta(@RequestBody ContaRequestDto requestDto) throws InterruptedException {
        Conta conta = contaService.criarConta(requestDto);

        Thread.sleep(5000);
        conta.setNumero(6543);
        contaRepository.save(conta);
        return conta.toContaDto();
    }


}