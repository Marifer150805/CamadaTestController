package com.teste.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservaTest {

	private Reserva reserva;
	private Hospede hospede;
	private Quarto quarto;

	@BeforeEach
	public void setUp() {
		// Arrange
		reserva = new Reserva(1L, LocalDate.of(2024, 8, 12), LocalDate.of(2024, 8, 15), hospede, quarto);
	}

	@Test
	public void testId() {
		//Act: Atribui o valor ao atributo 'id'
		reserva.setId(2L);
		// Assert: Verificar se o valor foi corretamente atribuido
		assertEquals(2L, reserva.getId(), "O ID deve ser igual ao valor atribuido");
	}

	@Test
	public void testHospede() {
		//Act: 
		reserva.setHospede(hospede);
		// Assert: 
		assertEquals(hospede, reserva.getHospede(), "O hospede deve ser igual ao valor atribuido");
	}

	@Test
	public void testQuarto() {
		//Act: 
		reserva.setQuarto(quarto);
		// Assert: 
		assertEquals(quarto, reserva.getQuarto(), "O quarto deve ser igual ao valor atribuido");
	}

	@Test
	public void testCheckInData() {
		//Act: 
		reserva.setCheckInData(LocalDate.of(2024, 9, 1));
		// Assert:
		assertEquals(LocalDate.of(2024, 9, 1), reserva.getCheckInData(),
				"A data de check-in deve ser igual ao valor atribuido");
	}

	@Test
	public void testCheckinoutData() {
		//Act: 
		reserva.setCheckOutData(LocalDate.of(2024, 9, 10));
		// Assert: 
		assertEquals(LocalDate.of(2024, 9, 10), reserva.getCheckOutData(),
				"A data de check-out deve ser igual ao valor atribuido");
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		//Act
		Reserva novaReserva = new Reserva(3L, LocalDate.of(2024, 9, 22), LocalDate.of(2024, 9, 25), hospede, quarto);
		//Assertion
		assertAll("novoReserva", () -> assertEquals(3l, novaReserva.getId()),
				() -> assertEquals(hospede, novaReserva.getHospede()),
				() -> assertEquals(quarto, novaReserva.getQuarto()),
				() -> assertEquals(LocalDate.of(2024, 9, 22), novaReserva.getCheckInData()),
				() -> assertEquals(LocalDate.of(2024, 9, 25), novaReserva.getCheckOutData()));
	}
}
