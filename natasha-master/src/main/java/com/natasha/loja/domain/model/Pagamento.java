package com.natasha.loja.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.natasha.loja.domain.model.enums.EnumEstadoPagamento;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private EnumEstadoPagamento estadoPagamento;

	// TODO PAGAMENTOCOMBOLETO E PAGAMENTOCOMCARTAO -- HERANCA && private

	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;

	public Pagamento() {
	}

	public Pagamento(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public EnumEstadoPagamento getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(EnumEstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
