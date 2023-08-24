package com.example.passagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.passagem.domain.dto.Usuario.UsuarioRequestDTO;
import com.example.passagem.domain.dto.Usuario.UsuarioResponseDTO;
import com.example.passagem.domain.service.UsuarioService;

@CrossOrigin("*")// nao ter trava na API
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obterTodos(){
        return ResponseEntity.ok(usuarioService.obterTodos());//retorna todos os usuarios em form de lista
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable Long id){//PathVariable -> passa os dados mostrando prousuario
        return ResponseEntity.ok(usuarioService.obterPorId(id)); //retorna o usuario do determinado id
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO dto){//requestBody -> passa os dados "escondido" sem q o usuario saiba
        UsuarioResponseDTO usuario = usuarioService.cadastrar(dto);
        return new ResponseEntity<UsuarioResponseDTO>(usuario, HttpStatus.CREATED); //retorna o usuario do determinado id
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){//requestBody -> passa os dados "escondido" sem q o usuario saiba
        UsuarioResponseDTO usuario = usuarioService.atualizar(id, dto);
        return new ResponseEntity<UsuarioResponseDTO>(usuario, HttpStatus.OK); //retorna o usuario do determinado id
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
