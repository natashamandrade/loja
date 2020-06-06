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

import com.natasha.loja.domain.dao.ProdutoDao;
import com.natasha.loja.domain.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoRest {

	@Autowired
	private ProdutoDao produtoDao;

	@GetMapping("/{id}")
	public Optional<Produto> findById(@PathVariable Integer id) {
		return produtoDao.findById(id);
	}

	@GetMapping
	public List<Produto> findAll() {
		return produtoDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Produto produto) {
		produtoDao.save(produto);
	}

	@PutMapping("/{id}")
	public Produto update(@PathVariable Integer id, @RequestBody Produto produto) {
		Optional<Produto> prod = produtoDao.findById(id);
		BeanUtils.copyProperties(produto, prod.get(), "id");
		return produtoDao.save(prod.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		produtoDao.deleteById(id);
	}

}
