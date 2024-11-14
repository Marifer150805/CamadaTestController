package com.teste.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		//Arrange
		hospede = new Hospede(1L, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		hospede.setId(2L);
		assertEquals(2L,hospede.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		hospede.setNome("Joao Paulo");
		assertEquals("Joao Paulo", hospede.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		//Act
		hospede.setEmail("joao@gmail.com");
		assertEquals("joao@gmail.com", hospede.getEmail());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		//Act
		hospede.setTelefone("(00)0000-0000");
		assertEquals("(00)0000-0000", hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		
		//Act 
		Hospede novoHospede = new Hospede(3L, "Matheus","matheus@gmail.com","(22)2222-2222");
		//Assention
		assertAll("novoHospede", 
				()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("Matheus", novoHospede.getNome()),
				()-> assertEquals("matheus@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("(22)2222-2222", novoHospede.getTelefone()));
	}

}
