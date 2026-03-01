package com.grupo1.cursosvulcano.repository;
import com.grupo1.cursosvulcano.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
