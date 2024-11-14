package com.teste.hospede.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.hospede.entities.Reserva;
import com.teste.hospede.repository.ReservaRepository;

public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	public Reserva salvarReserva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public List<Reserva> listarTodos() {
		return reservaRepository.findAll();
	}
	
	public Optional<Reserva> buscarPorId(Long id) {
		return reservaRepository.findById(id);
	}
	
	public Reserva atualizarReserva(Reserva Reserva) {
		if (reservaRepository.existsById(Reserva.getId())) {
			return reservaRepository.save(Reserva);
		} else {
			throw new RuntimeException("Reserva não encontrado");
		}
	}
	public void deletarReserva(Long id) {
		reservaRepository.deleteById(id);
	}

}
