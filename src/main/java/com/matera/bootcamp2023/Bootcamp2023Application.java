package com.matera.bootcamp2023;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.Servico;
import com.matera.bootcamp2023.carteira.Titular;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class Bootcamp2023Application {

	// static, final

	public static void main(String[] args) {
		SpringApplication.run(Bootcamp2023Application.class, args);

//		var pf = PessoaPF
//				.builder()
//				.cpf("1234")
//				.nome("Juliao")
//				.build();
//
//		System.out.println(pf);


//		var pf = new PessoaPF();
//		pf.setCpf("123456");
//		System.out.println(pf.getCpf());
//
//		pf.setNome("Juliao");
//		System.out.println(pf.getNome());

//		var s = new Servico();
//		s.contaMisteriosa();




//		var servico = new Servico();
//
//		var optConta = servico.contaMisteriosa();
//
//		var titular1 = new Titular("Mamedio", "12345678");
////		var conta = optConta.orElse(new Conta(3,4, BigDecimal.ONE, titular1));
////		var conta = optConta.orElseThrow();
////
////		if (Objects.isNull(conta)) {
////
////		}
//
	}

}
