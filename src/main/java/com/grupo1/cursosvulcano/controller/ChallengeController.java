package com.grupo1.cursosvulcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo1.cursosvulcano.service.ChallengeService;
import com.grupo1.cursosvulcano.model.Challenge;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    // Crear: POST http://localhost:8080/api/challenges
    @PostMapping
    public ResponseEntity<Challenge> crear(@RequestBody Challenge challenge) {
        Challenge nuevoDesafio = challengeService.creardesafio(challenge);
        return new ResponseEntity<>(nuevoDesafio, HttpStatus.CREATED);
    }

    // Listar todos: GET http://localhost:8080/api/challenges
    @GetMapping
    public ResponseEntity<List<Challenge>> listar() {
        return ResponseEntity.ok(challengeService.obtenerTodos());
    }

    // Obtener uno: GET http://localhost:8080/api/challenges/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Challenge> obtenerUno(@PathVariable Long id) {
        return ResponseEntity.ok(challengeService.buscarPorId(id));
    }

    // ✅ Actualizar: PUT http://localhost:8080/api/challenges/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Challenge> actualizar(@PathVariable Long id, @RequestBody Challenge challenge) {
        Challenge actualizado = challengeService.actualizarDesafio(id, challenge);
        return ResponseEntity.ok(actualizado);
    }

    // ✅ Eliminar: DELETE http://localhost:8080/api/challenges/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        challengeService.eliminarDesafio(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}