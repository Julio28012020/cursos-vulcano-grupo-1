package com.grupo1.cursosvulcano.service;

import org.springframework.stereotype.Service;

import com.grupo1.cursosvulcano.repository.ReviewRepository;
import com.grupo1.cursosvulcano.model.Review;

import java.util.List;

@Service
public class ReviewService {
  private final ReviewRepository reviewRepository;

      // Inyección de dependencias por constructor (más seguro que @Autowired)
      public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
      }
    
          // Método para registrar una nueva reseña
          public Review registrarReseña(Review review) {
            // En un entorno real, aquí encriptaríamos la contraseña antes de guardar
            return reviewRepository.save(review);
          }

        // Método para obtener la lista de todos las reseñas
        public List<Review> obtenerTodos() {
          return reviewRepository.findAll();
        }
    
            // Método para buscar reseñas por su ID
    public Review buscarPorId(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con ID: " + id));
    }

}
