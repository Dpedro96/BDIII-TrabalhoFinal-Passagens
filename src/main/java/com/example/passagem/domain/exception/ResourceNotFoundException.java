package com.example.passagem.domain.exception;

public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
    

