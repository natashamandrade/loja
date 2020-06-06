package com.natasha.loja.domain.model;

import org.springframework.stereotype.Component;

@Component
public class PagamentoComCartao extends Pagamento {

	private Integer numeroDeParcelas;

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
