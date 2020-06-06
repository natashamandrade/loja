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

import com.natasha.loja.domain.dao.PedidoDao;
import com.natasha.loja.domain.model.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidoRest {

	@Autowired
	private PedidoDao pedidoDao;

	@GetMapping("/{id}")
	public Optional<Pedido> findById(@PathVariable Integer id) {
		return pedidoDao.findById(id);
	}

	@GetMapping
	public List<Pedido> findAll() {
		return pedidoDao.findAll();
	}

	@PostMapping
	public void save(@RequestBody Pedido pedido) {
		pedidoDao.save(pedido);
	}

	@PutMapping("/{id}")
	public Pedido update(@PathVariable Integer id, @RequestBody Pedido pedido) {
		Optional<Pedido> ped = pedidoDao.findById(id);
		BeanUtils.copyProperties(pedido, ped.get(), "id");
		return pedidoDao.save(ped.get());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		pedidoDao.deleteById(id);
	}

}
