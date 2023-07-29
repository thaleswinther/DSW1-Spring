package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{

	Locacao findById(long id);

	List<Locacao> findAllByCliente(Cliente cliente);

	List<Locacao> findAllByLocadora(Locadora locadora);
	
	Locacao save(Locacao locacao);
}