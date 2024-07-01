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
import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.service.ProductoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoService service;
	/*
	@GetMapping("/productosPorCategoria")
    @ResponseStatus(HttpStatus.OK)
	public List<ProductosCategoria> productosPorCategoria(){
		return service.productoPorCategoria();
	}*/
	
	@GetMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto producto(@PathVariable Long id){
		System.out.println("Entro a esta funcion");
		System.out.println(id);
		Producto p = service.findById(id);
		return p;
	}
	
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> allProductos(){
		return service.findAll();
	}

	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto newProduct(@RequestBody Producto producto) {
		return service.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editProduct(@RequestBody Producto producto, @PathVariable Long id) {
		Producto p = service.findById(id);
		if (p == null) {
			return null;
		}
		producto.setIdProducto(id);
		return service.save(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id){
		service.delete(id);
	}
}
