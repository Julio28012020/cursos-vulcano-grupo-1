package com.grupo1.cursosvulcano.repository;

import com.grupo1.cursosvulcano.model.Challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    

}
