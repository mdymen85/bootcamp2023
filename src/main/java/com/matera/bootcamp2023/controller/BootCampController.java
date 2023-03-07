package com.matera.bootcamp2023.controller;

import com.matera.bootcamp2023.Fiat;
import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.ContaV2;
import com.matera.bootcamp2023.carteira.Titular;
import com.matera.bootcamp2023.carteira.TitularV2;
import com.matera.bootcamp2023.dto.ContaDto;
import com.matera.bootcamp2023.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "bootcamp-rest")
public class BootCampController {

    //Injecao de Dependencia
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping(value = "/conta")
    public ContaDto criarConta() {

        var conta = new Conta();
        conta.setNumero(10);
        conta.setAgencia(1);
        conta.setSaldo(BigDecimal.TEN);
        conta.setSenha("password");

        conta = contaRepository.save(conta);
        ContaDto dto = conta.toContaDto();

        return dto;


    }


}