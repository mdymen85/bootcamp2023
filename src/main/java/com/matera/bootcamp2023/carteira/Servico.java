package com.matera.bootcamp2023.carteira;

import java.math.BigDecimal;

public class Servico {

    public void transferenciaCredito(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        contaDestino.credito(valor);
    }

}