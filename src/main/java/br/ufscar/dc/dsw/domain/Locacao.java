package br.ufscar.dc.dsw.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
/*@Table(name = "Locacao",
       uniqueConstraints = {
           @UniqueConstraint(name = "unique_locacao_cliente_datahora", columnNames = {"cliente_id", "dataHora"}),
           @UniqueConstraint(name = "unique_locacao_locadora_datahora", columnNames = {"locadora_id", "dataHora"})
       })*/
@Table(name = "Locacao")
public class Locacao extends AbstractEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "locadora_id")
	private Locadora locadora;

	@NotNull(message = "{NotNull.locacao.data}")
	@Column(nullable = false, unique = false, length = 30)
	private String data;

	@NotNull(message = "{NotNull.locacao.hora}")
	@Column(nullable = false, unique = false)
	private String hora;
    
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}