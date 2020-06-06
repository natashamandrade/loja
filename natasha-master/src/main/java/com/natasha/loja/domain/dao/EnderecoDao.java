package com.natasha.loja.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natasha.loja.domain.model.Endereco;

@Repository
public interface EnderecoDao extends JpaRepository<Endereco, Integer> {

}
