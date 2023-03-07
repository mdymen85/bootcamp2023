package com.matera.bootcamp2023.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaDto {

    private int agencia;
    private int numero;
    private BigDecimal saldo;

}