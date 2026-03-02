package com.grupo1.cursosvulcano.service;

import org.springframework.stereotype.Service;

import com.grupo1.cursosvulcano.repository.ChallengeRepository;
import com.grupo1.cursosvulcano.model.Challenge;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public Challenge creardesafio(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public List<Challenge> obtenerTodos() {
        return challengeRepository.findAll();
    }

    public Challenge buscarPorId(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desafío no encontrado con ID: " + id));
    }

    // ✅ Actualizar un desafío existente
    public Challenge actualizarDesafio(Long id, Challenge nuevosDatos) {
        Challenge existente = buscarPorId(id);
        existente.setTitle(nuevosDatos.getTitle());
        existente.setDescription(nuevosDatos.getDescription());
        existente.setDifficulty(nuevosDatos.getDifficulty());
        existente.setBaseCode(nuevosDatos.getBaseCode());
        return challengeRepository.save(existente);
    }

    // ✅ Eliminar un desafío por ID
    public void eliminarDesafio(Long id) {
        buscarPorId(id); // Verifica que existe antes de eliminar
        challengeRepository.deleteById(id);
    }

}