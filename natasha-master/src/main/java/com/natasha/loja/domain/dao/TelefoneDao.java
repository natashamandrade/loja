package com.natasha.loja.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natasha.loja.domain.model.Telefone;

@Repository
public interface TelefoneDao extends JpaRepository<Telefone, Integer> {

}
