package com.dept.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.departamento.model.Projeto;
import com.dept.departamento.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public List<Projeto> getProjetosByDepartamentoId(Long departamentoId) {
        return projetoRepository.findByDepartamentoId(departamentoId);
    }

    public Projeto salvarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public void deletarProjeto(Long id) {
        projetoRepository.deleteById(id);
    }
}