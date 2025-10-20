package com.psii.appfiliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psii.appfiliacao.model.Mae;
import com.psii.appfiliacao.repository.MaeRepository;

@Service
public class MaeService {
    @Autowired
    private MaeRepository maeRepository;

    public List<Mae> listarMae(){
        return maeRepository.findAll();
    }
    public Mae salvarMae(Mae mae) {
        return maeRepository.save(mae);
    }
    public Mae buscarMae(Long id) {
        return maeRepository.findById(id).orElse(null);
    }
    public void deletarMae(Long id) {
        maeRepository.deleteById(id);
    }
}

