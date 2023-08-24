package com.example.passagem.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.passagem.common.ConversorData;
import com.example.passagem.domain.exception.ResourceBadRequestException;
import com.example.passagem.domain.exception.ResourceNotFoundException;
import com.example.passagem.domain.model.ErroResposta;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResposta> hadlerResponseNotFoundException(ResourceNotFoundException ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro = new ErroResposta(dataHora, HttpStatus.NOT_FOUND.value(), "Não Encontrado", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErroResposta> hadlerResponseBadRequestException(ResourceBadRequestException ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro = new ErroResposta(dataHora, HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> hadlerResponseException(Exception ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro = new ErroResposta(dataHora, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
