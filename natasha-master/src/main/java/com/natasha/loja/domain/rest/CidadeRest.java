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

import com.natasha.loja.domain.dao.CidadeDao;
import com.natasha.loja.domain.model.Cidade;

@RestController
@RequestMapping("/cidade")
public class CidadeRest {

	@Autowired
	private CidadeDao cidadeDao;

	@GetMapping("/{id}")
	public Optional<Cidade> findById(@PathVariable Integer id) {
		return cidadeDao.findById(id);
	}

	@GetMapping
	public List<Cidade> findAll() {
		return cidadeDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Cidade cidade) {
		cidadeDao.save(cidade);
	}

	@PutMapping("/{id}")
	public Cidade update(@PathVariable Integer id, @RequestBody Cidade cidade) {
		Optional<Cidade> cid = cidadeDao.findById(id);
		BeanUtils.copyProperties(cidade, cid.get(), "id");
		return cidadeDao.save(cid.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		cidadeDao.deleteById(id);
	}

}
