package com.matera.bootcamp2023.carteira;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configurationPrefix
@Configuration
public class Configs {

    @Value("${spring.application.name:}")
    private String nome;

    @Value("${outro-servico.url:}")
    private String url;

    @Bean
    public Aplicacao aplicacao() {
        var aplicacao = new Aplicacao();
        aplicacao.setNome(nome);
        System.out.println(aplicacao.getNome());
        return aplicacao;
    }


}
