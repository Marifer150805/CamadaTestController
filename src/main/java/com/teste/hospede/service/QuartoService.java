package com.teste.hospede.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.hospede.entities.Quarto;
import com.teste.hospede.repository.QuartoRepository;

public class QuartoService {
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	public Quarto salvarQuarto(Quarto quarto) {
		return quartoRepository.save(quarto);
	}
	
	public List<Quarto> listarTodos() {
		return quartoRepository.findAll();
	}
	
	public Optional<Quarto> buscarPorId(Long id) {
		return quartoRepository.findById(id);
	}
	
	public Quarto atualizarQuarto(Quarto Quarto) {
		if (quartoRepository.existsById(Quarto.getId())) {
			return quartoRepository.save(Quarto);
		} else {
			throw new RuntimeException("Quarto não encontrado");
		}
	}
	public void deletarQuarto(Long id) {
		quartoRepository.deleteById(id);
	}

}
