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

import com.natasha.loja.domain.dao.TelefoneDao;
import com.natasha.loja.domain.model.Telefone;

@RestController
@RequestMapping("/telefone")
public class TelefoneRest {

	@Autowired
	private TelefoneDao telefoneDao;

	@GetMapping("/{id}")
	public Optional<Telefone> findById(@PathVariable Integer id) {
		return telefoneDao.findById(id);
	}

	@GetMapping
	public List<Telefone> findAll() {
		return telefoneDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Telefone telefone) {
		telefoneDao.save(telefone);
	}

	@PutMapping("/{id}")
	public Telefone update(@PathVariable Integer id, @RequestBody Telefone telefone) {
		Optional<Telefone> tel = telefoneDao.findById(id);
		BeanUtils.copyProperties(telefone, tel.get(), "id");
		return telefoneDao.save(tel.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		telefoneDao.deleteById(id);
	}

}
