package com.dept.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.departamento.model.Funcionario;
import com.dept.departamento.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionario(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}