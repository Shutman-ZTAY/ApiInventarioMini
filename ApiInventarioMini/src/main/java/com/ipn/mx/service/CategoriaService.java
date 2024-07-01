package com.ipn.mx.service;

import com.ipn.mx.domain.entity.Categoria;
import java.util.List;

public interface CategoriaService {

	public Categoria insert(Categoria categoria);
	public void delete(Long id);
	public Categoria update(Categoria categoria);
	public List<Categoria> findAll();
	public Categoria findById(Long id);
	public void showById(Long id);
	public Categoria findRandom();
}
