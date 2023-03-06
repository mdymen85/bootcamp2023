package com.matera.bootcamp2023.carteira;

import java.math.BigDecimal;
import java.util.Optional;


public class Servico {

    public void transferenciaCredito(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        contaDestino.credito(valor);
    }

    public Optional<Conta> contaMisteriosa() {
        return Optional.empty();
//        var titular1 = new Titular("Mamedio", "12345678");
//        return Optional.of(new Conta(1,2, BigDecimal.ZERO, titular1));
    }

    public Optional<Conta> novaConta() {

        return Optional.empty();
    }

}