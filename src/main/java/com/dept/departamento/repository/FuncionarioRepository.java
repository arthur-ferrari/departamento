package com.psii.appfiliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.appfiliacao.model.Filiacao;

public interface FiliacaoRepository extends JpaRepository<Filiacao, Long>{
    List<Filiacao> findByMaeId(Long maeId);
    List<Filiacao> findByPaiId(Long paiID);
}
