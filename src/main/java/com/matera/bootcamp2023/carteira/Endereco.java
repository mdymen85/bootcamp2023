package com.matera.bootcamp2023.carteira;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    private Titular titular;

}