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

import com.natasha.loja.domain.dao.CategoriaDao;
import com.natasha.loja.domain.model.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaRest {

	@Autowired
	private CategoriaDao categoriaDao;

	@GetMapping("/{id}")
	public Optional<Categoria> findById(@PathVariable Integer id) {
		return categoriaDao.findById(id);
	}

	@GetMapping
	public List<Categoria> findAll() {
		return categoriaDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Categoria categoria) {
		categoriaDao.save(categoria);
	}

	@PutMapping("/{id}")
	public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria) {
		Optional<Categoria> cat = categoriaDao.findById(id);
		BeanUtils.copyProperties(categoria, cat.get(), "id");
		return categoriaDao.save(cat.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		categoriaDao.deleteById(id);
	}

}
