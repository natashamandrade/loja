package com.natasha.loja.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.natasha.loja.domain.model.enums.EnumTipoCliente;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String email;
	private String cpfOuCnpj;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	@Enumerated(EnumType.STRING)
	private EnumTipoCliente tipoCliente;

	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public EnumTipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(EnumTipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
