package com.example.passagem.domain.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPassagem")
    private Long id;
    @Column(nullable = false)
    private String localOrigem;
    @Column(nullable = false)
    private String localDestino;
    @Column(nullable = false)
    private Date dataSaida;
    @Column(nullable = false)
    private Date dataChegada;
    @Column(nullable = false)
    private String numAssento;
    @OneToOne //perguntar se pode ser ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
