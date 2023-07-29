package br.ufscar.dc.dsw.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

	@NotBlank(message = "{NotBlank.cliente.cpf}")
	@Size(max = 60)
	@Column(nullable = false, length = 60, unique = true)
	private String CPF;

	@NotBlank(message = "{NotBlank.cliente.telefone}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String telefone;
    
	@NotNull(message = "{NotNull.cliente.sexo}")
	@Column(nullable = false, length = 20)
	private String sexo;
	
	@NotNull(message = "{NotNull.cliente.dataNascimento}")
	@Column(nullable = false)
	private LocalDate dataNascimento;
    
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	private List<Locacao> locacoes;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		this.CPF= cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}