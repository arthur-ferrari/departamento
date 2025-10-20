package com.psii.appfiliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psii.appfiliacao.model.Filiacao;
import com.psii.appfiliacao.repository.FiliacaoRepository;

@Service
public class FiliacaoService {
@Autowired
    private FiliacaoRepository filiacaoRepository;
    
    public List<Filiacao> listarFiliacao() {
        return filiacaoRepository.findAll();
    }
    public List<Filiacao> getFiliacaoByMaeId(Long maeId) {
        return filiacaoRepository.findByMaeId(maeId);
    }
    public Filiacao salvarFiliacao(Filiacao filiacao) {
        return filiacaoRepository.save(filiacao);
    }
    public Filiacao buscarFiliacao(Long id) {
        return filiacaoRepository.findById(id).orElse(null);
    }
    public void deletarFiliacao(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarFiliacao'");
    }
}