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

import com.natasha.loja.domain.dao.ClienteDao;
import com.natasha.loja.domain.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;

	@GetMapping("/{id}")
	public Optional<Cliente> findById(@PathVariable Integer id) {
		return clienteDao.findById(id);
	}

	@GetMapping
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		clienteDao.save(cliente);
	}

	@PutMapping("/{id}")
	public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Optional<Cliente> cli = clienteDao.findById(id);
		BeanUtils.copyProperties(cliente, cli.get(), "id");
		return clienteDao.save(cli.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		clienteDao.deleteById(id);
	}

}
