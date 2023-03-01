package com.matera.bootcamp2023.carteira;

import java.util.ArrayList;
import java.util.List;

public class Titular {

    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Titular(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        contas = new ArrayList<>();
    }

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

    //nao é boa pratica expor a lista inteira
//    public List<Conta> getContas() {
//        return this.contas;
//    }
//
//    public void setContas(List<Conta> contas) {
//        this.contas = contas;
//    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
