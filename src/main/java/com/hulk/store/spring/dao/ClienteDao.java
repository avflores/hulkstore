package com.hulk.store.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.hulk.store.spring.modelo.Cliente;

/**
 * Interface de acceso a datos a la entidad Cliente
 * 
 * @author avfloresp
 *
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
