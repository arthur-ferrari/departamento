package com.dept.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dept.departamento.model.Funcionario;
import com.dept.departamento.service.FuncionarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "lista_funcionarios";
    }

    @GetMapping("/novo")
    public String novoFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "form_funcionario";
    }

    @PostMapping
    public String salvarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public String editarFuncionario(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioService.buscarFuncionario(id);
        model.addAttribute("funcionario", funcionario);
        return "form_funcionario";
    }

    @GetMapping("/{id}/deletar")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return "redirect:/funcionarios";
    }
}