package com.natasha.loja.domain.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PagamentoComBoleto extends Pagamento {

	private Date dataVencimento;
	private Date dataPagamento;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
