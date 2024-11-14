package com.teste.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.hospede.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long>{

}
