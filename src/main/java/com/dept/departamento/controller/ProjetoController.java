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

import com.dept.departamento.model.Projeto;
import com.dept.departamento.service.DepartamentoService;
import com.dept.departamento.service.FuncionarioService;
import com.dept.departamento.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping 
    public String listarProjetos(Model model) {
        List<Projeto> projetos = projetoService.listarProjetos();
        model.addAttribute("projetos", projetos);
        return "lista_projetos";
    }

    @GetMapping("/novo")
    public String novoProjeto(Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
        return "form_projeto.html";
    }

    @PostMapping 
    public String salvarProjeto(@ModelAttribute Projeto projeto) {
        projetoService.salvarProjeto(projeto);
        return "redirect:/projetos";
    }

    @GetMapping("/{id}/editar")
    public String editarProjeto(@PathVariable Long id, Model model) {
        Projeto projeto = projetoService.buscarProjeto(id);
        model.addAttribute("projeto", projeto);
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
        return "form_projeto";
    }

    @GetMapping("/{id}/deletar")
    public String deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return "redirect:/projetos";
    }
}