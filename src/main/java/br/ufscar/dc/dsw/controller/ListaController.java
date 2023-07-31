package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/lista")
public class ListaController {
    @Autowired
    private ILocadoraService locadoraService;

    @GetMapping("/locadoras")
    public String listar(@RequestParam(value = "filtroCidade", required = false) String filtroCidade, ModelMap model) {
        if (filtroCidade != null && !filtroCidade.isEmpty()) {
            model.addAttribute("locadoras", locadoraService.buscarPorCidade(filtroCidade));
        } else {
            model.addAttribute("locadoras", locadoraService.buscarTodos());
        }
        model.addAttribute("cidades", locadoraService.buscarTodasCidades());
        return "lista_locadoras";
    }
}
