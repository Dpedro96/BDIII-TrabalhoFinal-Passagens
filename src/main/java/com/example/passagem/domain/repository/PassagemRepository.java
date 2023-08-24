package com.example.passagem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.passagem.domain.model.Passagem;
import com.example.passagem.domain.model.Usuario;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
    List<Passagem> findByUsuario(Usuario usuario);
}
