package com.psii.appfiliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psii.appfiliacao.model.Pai;
import com.psii.appfiliacao.repository.PaiRepository;

@Service
public class PaiService {
    @Autowired
    private PaiRepository paiRepository;

    public List<Pai> listarPai() {
        return paiRepository.findAll();
    }
    public Pai salvarPai(Pai pai) {
        return paiRepository.save(pai);
    }
    public Pai buscarPai(Long id) {
        return paiRepository.findById(id).orElse(null);
    }
    public void deletarPai(Long id) {
        paiRepository.deleteById(id);
    }
}
