package com.matera.bootcamp2023;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.Titular;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

//@SpringBootApplication
public class Bootcamp2023Application {

	// static, final

	public static void main(String[] args) {

		var titular1 = new Titular("Mamedio", "12345678");

		var conta1 = new Conta(1,2, BigDecimal.ZERO, titular1);
		var conta2 = new Conta(3,4, BigDecimal.ONE, titular1);


		titular1.adicionarConta(conta1);
		titular1.adicionarConta(conta2);

		titular1.mostrarContas();


//		var pj = new PessoaPJ();
//		pj.setCnpj("234324");
//
//		var pf = new PessoaPF();
//		pf.setCpf("234324");
//
////		var p = new Pessoa();
//
//
//		var fiat = new Fiat("Siena", 2015);
//
//		System.out.println("fiat é velho = " + fiat.isVelho());
//
//		var chevrolet = new Chevrolet("Prisma", 2017);
//
//		System.out.println("chevrolet é velho = " + chevrolet.isVelho());

//
//		String nome = "Rosa";
//		nome = "Julio";
//
//
//		//instanciar
//		var pessoa = new Pessoa();
//		pessoa.setCpf("12345678912");
////		pessoa.setIdade(20);
//		pessoa.setNome("Pedrito");
//		System.out.println("nome = " + pessoa.getNome());
//		System.out.println("CONTADOR = " + Pessoa.CONTADOR);
//		System.out.println("idade = " + pessoa.getIdade());
//
//		pessoa = new Pessoa();
////
//
//		var pessoa2 = new Pessoa();
//		pessoa2.setCpf("12345678913");
//		pessoa2.setIdade(21);
//		pessoa2.setNome("Jaimnho");
//		System.out.println("nome = " + pessoa2.getNome());
//		System.out.println("CONTADOR = " + Pessoa.CONTADOR);
//		System.out.println("idade = " + pessoa2.getIdade());
//
//		pessoa.setNome("OutroNome");
//
//		System.out.println("nome = " + pessoa.getNome());
////		System.out.println("outro nome = " + pessoa2.getNome());
//		//SpringApplication.run(Bootcamp2023Application.class, args);
//
//		var outraPessoa = new Pessoa("1234");
//		System.out.println(outraPessoa.getCpf());
//
//		var terceiraPessoa = new Pessoa("9876", "NomeConstrutor");
//
//		System.out.println("terceira pessoa cpf = " + terceiraPessoa.getCpf());
//
////		var quartaPessoa = new Pessoa("1235", "nome", 15);
	}

}
