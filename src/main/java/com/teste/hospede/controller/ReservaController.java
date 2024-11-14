package com.teste.hospede.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.hospede.entities.Reserva;
import com.teste.hospede.service.ReservaService;

@RestController
@RequestMapping("/api/Reservas")
public class ReservaController {

    @Autowired
    private ReservaService ReservaService;

    @PostMapping
    public ResponseEntity<Reserva> salvarReserva(@RequestBody Reserva Reserva) {
        Reserva novoReserva = ReservaService.salvarReserva(Reserva);
        return new ResponseEntity<>(novoReserva, HttpStatus.CREATED);
    }

  
    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodos() {
        List<Reserva> Reservas = ReservaService.listarTodos();
        return new ResponseEntity<>(Reservas, HttpStatus.OK);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Optional<Reserva> Reserva = ReservaService.buscarPorId(id);
        return Reserva.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Long id, 
    											@RequestBody Reserva Reserva) {
        if (!ReservaService.buscarPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Reserva.setId(id);
        Reserva ReservaAtualizado = ReservaService.atualizarReserva(Reserva);
        return new ResponseEntity<>(ReservaAtualizado, HttpStatus.OK);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        if (!ReservaService.buscarPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReservaService.deletarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

