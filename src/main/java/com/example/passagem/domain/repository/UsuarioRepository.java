package com.example.passagem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.passagem.domain.model.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
