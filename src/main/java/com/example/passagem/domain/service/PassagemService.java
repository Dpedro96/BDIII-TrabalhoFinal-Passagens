package com.example.passagem.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.passagem.domain.dto.Passagem.PassagemRequestDTO;
import com.example.passagem.domain.dto.Passagem.PassagemResponseDTO;
import com.example.passagem.domain.exception.ResourceBadRequestException;
import com.example.passagem.domain.exception.ResourceNotFoundException;
import com.example.passagem.domain.model.Passagem;
import com.example.passagem.domain.model.Usuario;
import com.example.passagem.domain.repository.PassagemRepository;

@Service
public class PassagemService implements ICRUDService<PassagemRequestDTO, PassagemResponseDTO>{
    @Autowired
    private PassagemRepository passagemRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
        public List<PassagemResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Teste" + usuario);
        List<Passagem> passagems = passagemRepository.findByUsuario(usuario);
        return passagems.stream().map(passagem -> mapper.map(passagem, PassagemResponseDTO.class)).collect(Collectors.toList());
    }
    @Override
    public PassagemResponseDTO obterPorId(Long id) {
        Optional<Passagem> optPassagem = passagemRepository.findById(id);
        if(optPassagem.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o passgem com o id:" + id);
        }
        return mapper.map(optPassagem.get(), PassagemResponseDTO.class);
    }
    @Override
    public PassagemResponseDTO cadastrar(PassagemRequestDTO dto) {
        validarPassagem(dto);
        Passagem passagem = mapper.map(dto, Passagem.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        passagem.setUsuario(usuario);
        passagem.setId(null);
        passagem = passagemRepository.save(passagem);
        return mapper.map(passagem, PassagemResponseDTO.class);
    }
    @Override
    public PassagemResponseDTO atualizar(Long id, PassagemRequestDTO dto) {
        obterPorId(id);
        validarPassagem(dto);
        Passagem passagem = mapper.map(dto, Passagem.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        passagem.setUsuario(usuario);
        passagem.setId(id);
        passagem = passagemRepository.save(passagem);
        return mapper.map(passagem, PassagemResponseDTO.class);
    }
    @Override
    public void deletar(Long id) {
        obterPorId(id);
        passagemRepository.deleteById(id);
    }
        private void validarPassagem(PassagemRequestDTO dto){
        if(dto.getLocalOrigem() == null || dto.getLocalDestino() == null
        || dto.getDataSaida() == null || dto.getNumAssento() == null || dto.getDataChegada() == null){
            throw new ResourceBadRequestException("Passagem Inválida - os campos são obrigatórios!");
        }
    }

}