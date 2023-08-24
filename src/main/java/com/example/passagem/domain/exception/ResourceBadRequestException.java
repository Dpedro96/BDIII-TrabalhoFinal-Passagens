package com.example.passagem.domain.exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }
}
