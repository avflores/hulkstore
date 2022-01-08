package com.hulk.store.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.hulk.store.spring.modelo.Kardex;

public interface KardexDao extends CrudRepository<Kardex, Long> {

}
