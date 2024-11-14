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

import com.teste.hospede.entities.Quarto;
import com.teste.hospede.service.QuartoService;

@RestController
@RequestMapping("/api/Quartos")
public class QuartoController {

    @Autowired
    private QuartoService QuartoService;

    @PostMapping
    public ResponseEntity<Quarto> salvarQuarto(@RequestBody Quarto Quarto) {
        Quarto novoQuarto = QuartoService.salvarQuarto(Quarto);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    }

  
    @GetMapping
    public ResponseEntity<List<Quarto>> listarTodos() {
        List<Quarto> Quartos = QuartoService.listarTodos();
        return new ResponseEntity<>(Quartos, HttpStatus.OK);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
        Optional<Quarto> quarto = QuartoService.buscarPorId(id);
        return quarto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizarQuarto(@PathVariable Long id, 
    											@RequestBody Quarto Quarto) {
        if (!QuartoService.buscarPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Quarto.setId(id);
        Quarto quartoAtualizado = QuartoService.atualizarQuarto(Quarto);
        return new ResponseEntity<>(quartoAtualizado, HttpStatus.OK);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long id) {
        if (!QuartoService.buscarPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        QuartoService.deletarQuarto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

