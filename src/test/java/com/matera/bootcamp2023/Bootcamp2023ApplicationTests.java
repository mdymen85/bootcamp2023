package com.matera.bootcamp2023;

import com.matera.bootcamp2023.carteira.Aplicacao;
import com.matera.bootcamp2023.carteira.HelperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Bootcamp2023ApplicationTests {

	@Autowired
	private HelperService helperService;

	@Autowired
	private Aplicacao aplicacao;

	@Test
	void subtracaoTest() {
//		var helperService = new HelperService();

		var result = helperService.subtracao(3,2);

		assertEquals(1, result);

	}

	@Test
	void somaTest() {

//		var helperService = new HelperService();

		var result = helperService.soma(1,1);
		assertEquals(2,result);

		//carregar as variaveis
		//fazer as operações

		//validações dos resultados
//		assertTrue(1 != 1);


	}

}
