package com.matera.bootcamp2023;

public class Chevrolet extends Carro {

    public Chevrolet(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    protected boolean isVelho() {
        return false;
    }
}


//// Fiat <- Carro       (marca, modelo)
//// Chevrolet <- Carro   (marca, modelo)