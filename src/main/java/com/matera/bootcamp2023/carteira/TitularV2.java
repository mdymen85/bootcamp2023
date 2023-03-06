package com.matera.bootcamp2023.carteira;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class TitularV2 {

    private String nome;
    private String cpfCnpj;
    private List<Conta> contas;
    private String senha;

    public void mostrarContas() {
        //for, while, foreach, stream
        //for, com condição inical 0, até o tamanho da lista,
        //com incremento de 1 em 1.
        for (int i = 0; i < this.contas.size(); i = i + 1) {
            // i = 0. this.contas.get(0)
            // i = 1. this.contas.get(1)
            var conta = this.contas.get(i);

            //imprimo o nome
            System.out.println("agencia : " + conta.getAgencia() + " conta : " + conta.getNumero());

        }
    }



}