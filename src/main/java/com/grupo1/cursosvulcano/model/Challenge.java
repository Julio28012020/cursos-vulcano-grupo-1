package com.grupo1.cursosvulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String difficulty; // "Easy", "Medium", "Hard"

    @Column(columnDefinition = "TEXT")
    private String baseCode;

    @OneToMany(mappedBy = "challenge")
    private List<AcademicProgress> progressRecords;

    // ✅ Getters y Setters COMPLETOS
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getBaseCode() { return baseCode; }
    public void setBaseCode(String baseCode) { this.baseCode = baseCode; }

    public List<AcademicProgress> getProgressRecords() { return progressRecords; }
    public void setProgressRecords(List<AcademicProgress> progressRecords) { this.progressRecords = progressRecords; }

}