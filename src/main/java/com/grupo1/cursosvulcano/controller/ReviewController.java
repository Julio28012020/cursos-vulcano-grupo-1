package com.grupo1.cursosvulcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo1.cursosvulcano.service.ReviewService;
import com.grupo1.cursosvulcano.service.UserService;
import com.grupo1.cursosvulcano.model.Review;

import java.util.List;

@RestController
@RequestMapping("/api/reviews") // Ruta base para este controlador
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

        // Crear un review: POST http://localhost:8080/api/review
    @PostMapping
    public ResponseEntity<Review> crear(@RequestBody Review review) {
        Review nuevaResena = reviewService.registrarReseña(review);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED);
    }

    // Listar review: GET http://localhost:8080/api/review
    @GetMapping
    public ResponseEntity<List<Review>> listar() {
        List<Review> reviews = reviewService.obtenerTodos();
        return ResponseEntity.ok(reviews);
    }

    // Obtener uno: GET http://localhost:8080/api/review/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Review> obtenerUno(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.buscarPorId(id));
    }

}
