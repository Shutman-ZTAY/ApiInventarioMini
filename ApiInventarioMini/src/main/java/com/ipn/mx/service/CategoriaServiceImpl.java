package com.ipn.mx.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;
import com.ipn.mx.domain.entity.Categoria;
import com.ipn.mx.domain.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository ctgRep;
	
	@Override
	@Transactional(readOnly = false)
	public Categoria insert(Categoria categoria) {
		return ctgRep.save(categoria);
	}

	@Override
	public void delete(Long id) {
		ctgRep.deleteById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Categoria update(Categoria categoria) {
		Categoria ctg = ctgRep.findById(categoria.getIdCategoria()).orElse(null);
		if (ctg == null) {
			return null;
		}
		return ctgRep.save(categoria);
	}

	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) ctgRep.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return ctgRep.findById(id).orElse(null);
	}

	@Override
	public void showById(Long id) {
		Categoria ctg = ctgRep.findById(id).orElse(null);
		System.out.println(ctg);
	}

	@Override
	public Categoria findRandom() {
		Random r = new Random();
		int value = r.nextInt((int) ctgRep.count()) + 1;
		Categoria ctg = ctgRep.findById(Long.valueOf((long) value)).orElse(null);
		return ctg;
	}

}
