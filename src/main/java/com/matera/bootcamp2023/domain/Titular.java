package com.matera.bootcamp2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Titular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Endereco endereco;

    //    @JsonIgnore
    @OneToMany(mappedBy = "titular")
    private List<Conta> contas = new ArrayList<>();

}