package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locadora;

public interface ILocadoraService {

	Locadora buscarPorId(Long id);

	List<Locadora> buscarTodos();

    List<Locadora> buscarPorCidade(String cidade);

	List<String> buscarTodasCidades();

	void salvar(Locadora locadora);

	void excluir(Long id);

	boolean locadoraTemLocacoes(Long id);

}
