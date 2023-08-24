package com.example.passagem.domain.dto.Passagem;

import java.util.Date;


public class PassagemRequestDTO {
    private Long id;
    private String localOrigem;
    private String localDestino;
    private Date dataSaida;
    private Date dataChegada;
    private String numAssento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLocalOrigem() {
        return localOrigem;
    }
    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }
    public String getLocalDestino() {
        return localDestino;
    }
    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }
    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    public Date getDataChegada() {
        return dataChegada;
    }
    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }
    public String getNumAssento() {
        return numAssento;
    }
    public void setNumAssento(String numAssento) {
        this.numAssento = numAssento;
    }
}
