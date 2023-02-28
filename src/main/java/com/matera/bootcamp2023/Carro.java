package com.matera.bootcamp2023;

public abstract class Carro {

    private String modelo;
    private int ano;
    private static int VELHICE = 2015;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    protected abstract boolean isVelho();




}
