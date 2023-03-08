package com.matera.bootcamp2023.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaRequestDto {

    private int agencia;
    private String nome;
    private String cpf;
}