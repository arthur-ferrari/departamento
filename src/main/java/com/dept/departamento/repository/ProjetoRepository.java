package com.dept.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dept.departamento.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    List<Projeto> findByFuncionarioId(Long funcionarioId);
    List<Projeto> findByDepartamentoId(Long departamentoID);
}
