package com.dept.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.departamento.model.Departamento;
import com.dept.departamento.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento salvarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento buscarDepartamento(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public void deletarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}