package com.ipn.mx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.domain.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository repository;
	/*
	@Override
	@Transactional(readOnly = true)
	public List<ProductosCategoria> productoPorCategoria() {
		List<Object[]> resultados = 
				repository.contarProductoPorCategoria();
		List<ProductosCategoria> lista = new ArrayList<>();
		for (Object[] registro : resultados) {
			ProductosCategoria pc = new ProductosCategoria();
			pc.setCantidad((Long) registro[1]);
			pc.setCategoria((String) registro[0]);
		}
		return lista;
	}
*/
	@Override
	public Producto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Producto> findAll() {
		return repository.findAll();
	}

}
