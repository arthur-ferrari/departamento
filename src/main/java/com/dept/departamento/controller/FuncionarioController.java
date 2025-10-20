package com.dept.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appfiliacao.model.Filiacao;
import com.psii.appfiliacao.service.FiliacaoService;
import com.psii.appfiliacao.service.MaeService;
import com.psii.appfiliacao.service.PaiService;

@Controller
@RequestMapping("/filiacoes")
public class FiliacaoController {

    @Autowired
    private FiliacaoService filiacaoservice;

    @Autowired
    private MaeService maeService;

    @Autowired
    private PaiService paiService;

    @GetMapping 
    public String listarFiliacao(Model model) {
        List<Filiacao> filiacao = filiacaoservice.listarFiliacao();
        model.addAttribute("filiacao", filiacao);
        return "lista_filiacoes";
    }

    @GetMapping("/novo")
    public String novaFiliacao(Model model) {
        model.addAttribute("filiacao", new Filiacao());
        model.addAttribute("mae", maeService.listarMae());
        model.addAttribute("pai", paiService.listarPai());
        return "form_filiacao";
    }

    @PostMapping 
    public String salvarFiliacao(@ModelAttribute Filiacao filiacao) {
        filiacaoservice.salvarFiliacao(filiacao);
        return "redirect:/filiacoes";
    }

    @GetMapping("/{id}/editar")
    public String editarFiliacao(@PathVariable Long id, Model model) {
        Filiacao filiacao = filiacaoservice.buscarFiliacao(id);
        model.addAttribute("filiacao", filiacao);
        model.addAttribute("mae", maeService.listarMae());
        model.addAttribute("pai", paiService.listarPai());
        return "form_filiacao";
    }

    @GetMapping("/{id}/deletar")
    public String deletarConsulta(@PathVariable Long id){
        filiacaoservice.deletarFiliacao(id);
        return "redirect:/filiacoes";
}
}