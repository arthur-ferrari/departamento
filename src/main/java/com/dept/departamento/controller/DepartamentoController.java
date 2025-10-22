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

import com.dept.departamento.model.Departamento;
import com.dept.departamento.model.Projeto;
import com.dept.departamento.service.DepartamentoService;
import com.dept.departamento.service.ProjetoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public String listarDepartamentos(Model model) {
        List<Departamento> departamentos = departamentoService.listarDepartamentos();
        for (Departamento departamento : departamentos) {
            // Carregar os projetos para cada departamento
            List<Projeto> projetos = projetoService.getProjetosByDepartamentoId(departamento.getId());
            departamento.setProjetos(projetos);
        }
        model.addAttribute("departamentos", departamentos);
        return "lista_departamentos";
    }

    @GetMapping("/novo")
    public String novoDepartamento(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "form_departamento";
    }

    @PostMapping
    public String salvarDepartamento(@ModelAttribute Departamento departamento) {
        departamentoService.salvarDepartamento(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/{id}/editar")
    public String editarDepartamento(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoService.buscarDepartamento(id);
        model.addAttribute("departamento", departamento);
        return "form_departamento";
    }

    @GetMapping("/{id}/deletar")
    public String deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
        return "redirect:/departamentos";
    }
}