package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.ipn.mx.domain.entity.Categoria;
import com.ipn.mx.service.CategoriaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class CategoriaController {

	@Autowired
	CategoriaService service;
	
	@GetMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public List<Categoria> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Categoria findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria nuevaCategoria(@RequestBody Categoria categoria) {
		return service.insert(categoria);
	}
	
	@PutMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria cambiarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
		categoria.setIdCategoria(id);
		return service.update(categoria);
	}
	
	@DeleteMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarCategoria(@PathVariable Long id) {
		service.delete(id);
	}
}
