package com.natasha.loja.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natasha.loja.domain.model.Pagamento;

@Repository
public interface PagamentoDao extends JpaRepository<Pagamento, Integer> {

}
