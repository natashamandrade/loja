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

import com.natasha.loja.domain.dao.EstadoDao;
import com.natasha.loja.domain.model.Estado;

@RestController
@RequestMapping("/estado")
public class EstadoRest {

	@Autowired
	private EstadoDao estadoDao;

	@GetMapping("/{id}")
	public Optional<Estado> findById(@PathVariable Integer id) {
		return estadoDao.findById(id);
	}

	@GetMapping
	public List<Estado> findAll() {
		return estadoDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Estado estado) {
		estadoDao.save(estado);
	}

	@PutMapping("/{id}")
	public Estado update(@PathVariable Integer id, @RequestBody Estado estado) {
		Optional<Estado> est = estadoDao.findById(id);
		BeanUtils.copyProperties(estado, est.get(), "id");
		return estadoDao.save(est.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		estadoDao.deleteById(id);
	}

}
