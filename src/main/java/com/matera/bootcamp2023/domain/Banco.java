package com.matera.bootcamp2023.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;

@Getter
@Setter
@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int codigo = new Random().nextInt(1000);
    private String nome;
}