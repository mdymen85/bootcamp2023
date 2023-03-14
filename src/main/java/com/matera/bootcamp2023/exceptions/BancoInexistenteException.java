package com.matera.bootcamp2023.exceptions;

public class BancoInexistenteException extends RuntimeException{

    public BancoInexistenteException(String message) {
        super(message);
    }
}