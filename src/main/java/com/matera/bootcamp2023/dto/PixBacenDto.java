package com.matera.bootcamp2023.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PixBacenDto {

    private int agencia;
    private String cpf;
    private int numero;
    private String chave;

    @Override
    public String toString() {
        return "PixBacenDto{" +
                "agencia=" + agencia +
                ", cpf='" + cpf + '\'' +
                ", numero=" + numero +
                ", chave='" + chave + '\'' +
                '}';
    }
}