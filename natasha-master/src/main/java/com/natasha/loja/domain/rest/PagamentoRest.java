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

import com.natasha.loja.domain.dao.PagamentoDao;
import com.natasha.loja.domain.model.Pagamento;

@RestController
@RequestMapping("/pagamento")
public class PagamentoRest {

	@Autowired
	private PagamentoDao pagamentoDao;

	@GetMapping("/{id}")
	public Optional<Pagamento> findById(@PathVariable Integer id) {
		return pagamentoDao.findById(id);
	}

	@GetMapping
	public List<Pagamento> findAll() {
		return pagamentoDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Pagamento pagamento) {
		pagamentoDao.save(pagamento);
	}

	@PutMapping("/{id}")
	public Pagamento update(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
		Optional<Pagamento> pag = pagamentoDao.findById(id);
		BeanUtils.copyProperties(pagamento, pag.get(), "id");
		return pagamentoDao.save(pag.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		pagamentoDao.deleteById(id);
	}

}
