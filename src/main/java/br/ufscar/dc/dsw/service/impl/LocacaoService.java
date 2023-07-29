package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Service
@Transactional(readOnly = false)
public class LocacaoService implements ILocacaoService {

	@Autowired
	ILocacaoDAO dao;
	
	public void salvar(Locacao locacao) {
		dao.save(locacao);
	}

	@Transactional(readOnly = true)
	public Locacao buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorCliente(Cliente cliente) {
		return dao.findAllByCliente(cliente);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorLocadora(Locadora locadora) {
		return dao.findAllByLocadora(locadora);
	}
}