package com.dept.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dept.departamento.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
