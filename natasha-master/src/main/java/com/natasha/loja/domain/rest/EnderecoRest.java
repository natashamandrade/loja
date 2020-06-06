package com.natasha.loja.domain.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natasha.loja.domain.dao.EnderecoDao;
import com.natasha.loja.domain.model.Endereco;

@RestController
@RequestMapping("/endereco")
public class EnderecoRest {

	@Autowired
	private EnderecoDao enderecoDao;

	@GetMapping("/{id}")
	public Optional<Endereco> findById(@PathVariable Integer id) {
		return enderecoDao.findById(id);
	}

	@GetMapping
	public List<Endereco> findAll() {
		return enderecoDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Endereco endereco) {
		enderecoDao.save(endereco);
	}

	@PutMapping("/{id}")
	public Endereco update(@PathVariable Integer id, @RequestBody Endereco endereco) {
		Optional<Endereco> end = enderecoDao.findById(id);
		BeanUtils.copyProperties(endereco, end.get(), "id");
		return enderecoDao.save(end.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		enderecoDao.deleteById(id);
	}

}
