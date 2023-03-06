package com.matera.bootcamp2023;

import lombok.*;

//@Data
//@Builder
public class PessoaPF extends Pessoa {

    private String cpf;
    private String nome;

    @Override
    public String toString() {
        return "PessoaPF{" +
                "cpf=" + cpf +
                ", nome=" + nome +
                '}';
    }
}
