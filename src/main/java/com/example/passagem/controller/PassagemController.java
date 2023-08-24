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

import com.example.passagem.domain.dto.Passagem.PassagemRequestDTO;
import com.example.passagem.domain.dto.Passagem.PassagemResponseDTO;
import com.example.passagem.domain.service.PassagemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/passagens")
public class PassagemController {
    @Autowired
    private PassagemService passagemService;

    @GetMapping
    public ResponseEntity<List<PassagemResponseDTO>> obterTodos(){
        return ResponseEntity.ok(passagemService.obterTodos());
    }

    @GetMapping("/{id}")
        public ResponseEntity<PassagemResponseDTO> obterPorId(@PathVariable Long id){
            return ResponseEntity.ok(passagemService.obterPorId(id));
        }

    @PostMapping
    public ResponseEntity<PassagemResponseDTO> cadastrar(@RequestBody PassagemRequestDTO dto){
        PassagemResponseDTO responseDTO = passagemService.cadastrar(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassagemResponseDTO> atualizar(@PathVariable Long id, @RequestBody PassagemRequestDTO dto){
        PassagemResponseDTO responseDTO = passagemService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        passagemService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
