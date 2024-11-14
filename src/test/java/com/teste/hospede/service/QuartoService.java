package com.teste.hospede.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.hospede.entities.Quarto;
import com.teste.quarto.entities.quarto;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
class quartoService {

	@Autowired
	private QuartoService quartoService;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@BeforeEach
	void setUp() {
		quartoRepository.deleteAll();
	}
	@DisplayName("Testando salvar quarto")
	@Test
	
	void testSalvarquarto() {
		quarto quarto = new quarto(null, "Julia", "julia@gmail.com", "00000000");
		
		quarto resultado = quartoService.salvarquarto(quarto);
		
		assertNotNull(resultado);
		assertEquals("julia", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	
	@DisplayName("Testando listar todos os quartos")
	@Test
	
	void testListarTodos() {
		Quarto quarto1 = new quarto(null, "julia", "julia@gmail.com", "000000000");
		Quarto quarto2 = new quarto(null, "julio", "julio@gmail.com", "111111111");
		
		quartoService.salvarquarto(quarto1);
		quartoService.salvarquarto(quarto2);
		
		List<quarto> resultado = quartoService.listarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar quarto por ID")
	@Test
	
	void testBuscarPorId() {
		Quarto quarto = new quarto(null, "Julia", "julia@gmail.com", "2222222222");
		
		Quarto salvo = quartoService.salvarquarto(quarto);
		Optional<quarto> resultado = quartoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("Julia", resultado.get().getNome());
	}
	
	@DisplayName("Testando atualizar quarto")
	@Test
	
	void testAtualizarquarto() {
		Quarto quarto = new quarto(null, "Julia", "julia@gmail.com", "00000000000");
		Quarto salvo = quartoService.salvarquarto(quarto);
		
		salvo.setNome("Morelli");
		salvo.setEmail("morelli@gmail.com");
		
		Quarto atualizar = quartoService.atualizarquarto(salvo);
		
		assertNotNull(atualizar);
		assertEquals("Leonardo", atualizado.getNome());
		assertEquals("leonardo@gmail.com", atualizado.getEmail());
	}
	
	@DisplayName("Testando deletar quarto")
	@Test
	void testDeletarquarto() {
		Quarto quarto = new quarto(null, "Julia", "julia@gmail.com", "0000000000");
		
		Quarto salvo = quartoService.salvarquarto(quarto);
		quartoService.deletarquarto(salvo.getId());
		
		Optional<quarto> resultado = quartoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	
	}
}
