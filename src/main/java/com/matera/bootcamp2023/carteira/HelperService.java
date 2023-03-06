package com.matera.bootcamp2023.carteira;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelperService {

    @Value("${outro-servico.user:}")
    private String user;

    public int soma(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a -b;
    }

}
