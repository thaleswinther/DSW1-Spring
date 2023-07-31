package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, String>{

	Locadora findById(long id);

	Locadora findByCNPJ (String CNPJ);

	List<Locadora> findByCidade (String cidade);

	List<Locadora> findAll();

	Locadora save(Locadora locadora);

	void deleteById(Long id);

	@Query("SELECT DISTINCT cidade FROM Locadora")
    List<String> findAllCidades();
}
