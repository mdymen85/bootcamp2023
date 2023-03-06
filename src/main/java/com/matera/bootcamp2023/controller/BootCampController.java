package com.matera.bootcamp2023.controller;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.ContaV2;
import com.matera.bootcamp2023.carteira.Titular;
import com.matera.bootcamp2023.carteira.TitularV2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "bootcamp-rest")
public class BootCampController {

    @RequestMapping(value = "/conta", headers = "versao=1", )
    public Conta obterConta() {

        var conta = new Conta();
        conta.setAgencia(10);
        conta.setNumero(20);
        conta.setSaldo(BigDecimal.TEN);

        var titular = Titular.builder()
                .cpf("9999999999")
                .nome("Mamedio")
                .build();

        conta.setTitular(titular);

        return conta;

    }

    /*@DeleteMapping(value = "/conta")
    @GetMapping(value = "/conta")
    @PostMapping(value = "/conta")
    @PutMapping(value = "/conta")*/
    @RequestMapping(value = "/conta", method = RequestMethod.DELETE)
    public ContaV2 obterContaV2() {
        var conta = new ContaV2();
        conta.setAgencia(10);
        conta.setNumero(20);
        conta.setSaldo(BigDecimal.TEN);

        var titularV2 = TitularV2.builder().
                cpfCnpj("99.999.9999/99").nome("Razao social NNNN").build();

        conta.setTitular(titularV2);

        return conta;
    }

}