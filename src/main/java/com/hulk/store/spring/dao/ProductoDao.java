package com.hulk.store.spring.dao;


import org.springframework.data.repository.CrudRepository;

import com.hulk.store.spring.modelo.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

	
}
