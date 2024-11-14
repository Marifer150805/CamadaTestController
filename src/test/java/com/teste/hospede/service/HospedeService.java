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

import com.teste.hospede.entities.Hospede;
import com.teste.hospede.repository.HospedeRepository;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
class HospedeService {

	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll();
	}
	@DisplayName("Testando salvar Hospede")
	@Test
	
	void testSalvarHospede() {
		Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "00000000");
		
		Hospede resultado = hospedeService.salvarHospede(hospede);
		
		assertNotNull(resultado);
		assertEquals("julia", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	
	@DisplayName("Testando listar todos os hospedes")
	@Test
	
	void testListarTodos() {
		Hospede hospede1 = new Hospede(null, "julia", "julia@gmail.com", "000000000");
		Hospede hospede2 = new Hospede(null, "julio", "julio@gmail.com", "111111111");
		
		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2);
		
		List<Hospede> resultado = hospedeService.listarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar Hospede por ID")
	@Test
	
	void testBuscarPorId() {
		Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "2222222222");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("Julia", resultado.get().getNome());
	}
	
	@DisplayName("Testando atualizar Hospede")
	@Test
	
	void testAtualizarHospede() {
		Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "00000000000");
		Hospede salvo = hospedeService.salvarHospede(hospede);
		
		salvo.setNome("Morelli");
		salvo.setEmail("morelli@gmail.com");
		
		Hospede atualizar = hospedeService.atualizarHospede(salvo);
		
		assertNotNull(atualizar);
		assertEquals("Leonardo", atualizado.getNome());
		assertEquals("leonardo@gmail.com", atualizado.getEmail());
	}
	
	@DisplayName("Testando deletar Hospede")
	@Test
	void testDeletarHospede() {
		Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "0000000000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		hospedeService.deletarHospede(salvo.getId());
		
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	
	}
}
