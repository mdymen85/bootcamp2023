package com.matera.bootcamp2023.carteira;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @OneToMany(mappedBy = "titular")
    private List<Conta> contas = new ArrayList<>();

}