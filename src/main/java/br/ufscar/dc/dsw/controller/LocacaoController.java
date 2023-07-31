package br.ufscar.dc.dsw.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private ILocacaoService service;
	
	@Autowired
	private ILocadoraService locadoraService;

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao) {
		
		return "locacao/cadastro";
	}
	
	private Cliente getClienteLogado(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails user = (UsuarioDetails) auth.getPrincipal();
		return clienteService.buscarPorId(user.getUsuario().getId());
    }

	private Locadora getLocadoraLogada(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails user = (UsuarioDetails) auth.getPrincipal();
		return locadoraService.buscarPorId(user.getUsuario().getId());
    }
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsuarioDetails user = (UsuarioDetails) auth.getPrincipal();
        if( user.getUsuario().getRole().equals("ROLE_Cliente")){
            model.addAttribute("locacoes", service.buscarTodosPorIdCliente(getClienteLogado().getId()));
        }else if( user.getUsuario().getRole().equals("ROLE_Locadora") ){
            model.addAttribute("locacoes", service.buscarTodosPorIdLocadora(getLocadoraLogada().getId()));
        }
		
		return "locacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locacao locacao, BindingResult result, RedirectAttributes attr) {
		Cliente cliente = getClienteLogado();

		if (result.hasErrors()) {
			return "locacao/cadastro";
		}

		String hora = locacao.getHora();
		if (hora.length() == 1) {
			hora = "0" + hora;
		}

		// Specify the format of the date used in the form
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate locacaoDate = LocalDate.parse(locacao.getData(), formatter);
		
		
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		if (locacaoDate.isBefore(currentDate)) {
			attr.addFlashAttribute("error", "locacao.create.fail");
			return "redirect:/locacoes/cadastrar";
		}

		locacao.setCliente(cliente);
		locacao.setHora(hora + ":00:00");
		service.salvar(locacao);
		attr.addFlashAttribute("success", "locacao.create.success");
		return "redirect:/locacoes/listar";
	}

	
	@ModelAttribute("locadoras")
	public List<Locadora> listaLocadoras() {
		return locadoraService.buscarTodos();
	}
}