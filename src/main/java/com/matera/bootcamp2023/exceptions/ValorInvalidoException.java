package com.matera.bootcamp2023.exceptions;

public class ValorInvalidoException extends RuntimeException{

    public ValorInvalidoException(String message) {
        super(message);
    }
}