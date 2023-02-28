package com.matera.bootcamp2023;

public class Fiat extends Carro {

    public Fiat(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override //sobreescrita
    protected boolean isVelho() {
        return false;
    }
}
