/**
 * 
 */
package com.hulk.store.spring.servicio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulk.store.spring.dao.MarcaDao;
import com.hulk.store.spring.modelo.Marca;
/**
 * 
 * @author avfloresp
 *
 */
@SpringBootTest
public class MarcaTest {

	@Autowired
	private MarcaServicio marcaServicio;
	
	@Mock
	private MarcaDao marcaDao;

	@Test
	public void deberiaListarMarcas() {
		List<Marca> listaMarca = new ArrayList<>();
		listaMarca.add(new Marca());
		Iterable<Marca> categorias = listaMarca;
		marcaDao = Mockito.mock(MarcaDao.class);
		Mockito.when(marcaDao.findAll()).thenReturn(categorias);
		Assertions.assertNotNull(marcaServicio.listar(), "ok");
	}
	
	@Test
	public void deberiaObtenerPorId() {
		Assertions.assertNotNull(marcaServicio.listar(), "objeto nulo");
	}
}
