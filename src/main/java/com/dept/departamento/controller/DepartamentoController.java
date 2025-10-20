package com.psii.appfiliacao.controller;

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
import com.psii.appfiliacao.model.Mae;
import com.psii.appfiliacao.service.FiliacaoService;
import com.psii.appfiliacao.service.MaeService;

@Controller
@RequestMapping("/maes")
public class MaeController {

    @Autowired
    private MaeService maeService;
    @Autowired
    private FiliacaoService filiacaoService;

    @GetMapping  
    public String listarMaes(Model model) {
        List<Mae> maes = maeService.listarMae(); // Listar todas as Mães
        for (Mae mae : maes) {
            // Carregar os filhos para cada mãe
            List<Filiacao> filhos = filiacaoService.getFiliacaoByMaeId(mae.getId());
            mae.setFiliacao(filhos); // Associar a lista de filhos à mãe
        }
        model.addAttribute("maes", maes); // Passar as mães e seus filhos para o template
        return "lista_maes"; // Retorna para o template de listar-maes
    }
    @GetMapping("/novo")
    public String novoMae(Model model){
        model.addAttribute("mae", new Mae());
        return "form_mae";
    }

    @PostMapping
    public String salvarMae(@ModelAttribute Mae mae){
        maeService.salvarMae(mae);
        return "redirect:/maes";
    }
     @GetMapping("/{id}/editar")
    public String editarMae(@PathVariable Long id, Model model) {
        Mae mae = maeService.buscarMae(id);
        model.addAttribute("mae", mae);
        return "form_mae";
    }
    @GetMapping("/{id}/deletar")
    public String deletarMae(@PathVariable Long id) {
        maeService.deletarMae(id);
        return "redirect:/maes";
    }
}