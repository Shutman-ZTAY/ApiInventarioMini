package com.ipn.mx.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.mx.domain.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
