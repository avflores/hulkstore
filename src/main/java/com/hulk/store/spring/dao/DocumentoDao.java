package com.hulk.store.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.hulk.store.spring.modelo.Documento;

public interface DocumentoDao extends CrudRepository<Documento,Long> {

}
