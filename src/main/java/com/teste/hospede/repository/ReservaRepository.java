package com.teste.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.hospede.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
