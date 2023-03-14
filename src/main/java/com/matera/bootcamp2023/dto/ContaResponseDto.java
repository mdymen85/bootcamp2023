package com.matera.bootcamp2023.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaResponseDto {

    private int agencia;
    private int numero;
    private BigDecimal saldo;
    private String chavePix;

}