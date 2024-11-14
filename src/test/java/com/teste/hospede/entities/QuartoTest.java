package com.teste.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {
	
	private Quarto quarto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		quarto = new Quarto(1L, "3", "Suite");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		quarto.setId(2L);
		assertEquals(2L,quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
		//Act
		quarto.setNum("2");
		assertEquals("2", quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
		//Act
		quarto.setTipo("Suite");
		assertEquals("Suite", quarto.getTipo());
	}
	
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		
		//Act 
		Quarto novoQuarto = new Quarto(3L, "2","Solteiro");
		//Assention
		assertAll("novoQuarto", 
				()-> assertEquals(3L, novoQuarto.getId()),
				()-> assertEquals("2", novoQuarto.getNum()),
				()-> assertEquals("Solteiro", novoQuarto.getTipo()));
				
	}
}
