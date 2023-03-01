package com.matera.bootcamp2023.carteira;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pix {

    private Conta contaDestino;
    private Conta contaOrigem;
    private LocalDateTime dataTransacao;
    private BigDecimal valor;

    public Pix(Conta contaDestino, Conta contaOrigem, BigDecimal valor) {
        this.contaDestino = contaDestino;
        this.contaOrigem = contaOrigem;
        this.valor = valor;
        dataTransacao = LocalDateTime.now();
    }

}
