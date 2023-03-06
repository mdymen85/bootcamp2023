package com.matera.bootcamp2023.carteira;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaV2 {

    private int agencia;
    private int numero;
    private BigDecimal saldo;
    private TitularV2 titular;

    public ContaV2() {}


    //credito, debito
    public void credito(BigDecimal valor) {

        this.validar(valor);

        saldo.add(valor);

    }

    public void debito(BigDecimal valor) {

        this.validar(valor);

        // -1 se for menor
        // 0 se for igual
        // 1 se for maior

        // valor = 100
        // saldo = 250
        // 100.compareTo(250) > 0 -> -1
        //if (-1 > 0) { nao entro }

        // valor = 100
        // saldo = 50

        // 100.compareTo(50) > 0 -> 1
        //if (1 > 0) { sim entro }

        if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException();
        }

        saldo.subtract(valor);

    }

    /**
     * este metodo...
     * @param valor
     */
    private void validar(BigDecimal valor) {

        if (valor == null) {
            throw new RuntimeException();
        }

        if (this.valorIncorreto(valor)) {
            throw new RuntimeException();
        }

    }

    private boolean valorIncorreto(BigDecimal valor) {
        //NPE
        return valor.compareTo(BigDecimal.ZERO) <= 0;
    }



}