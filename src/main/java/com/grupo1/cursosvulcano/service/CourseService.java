package com.grupo1.cursosvulcano.service;

import java.util.List;
import com.grupo1.cursosvulcano.model.entity.Course;
import com.grupo1.cursosvulcano.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public Course createCourse(Course course) {
        if (Boolean.TRUE.equals(course.getIsPublished())) {
            // Un curso nuevo por definición no tiene módulos aún en este flujo
            throw new IllegalArgumentException("No se puede publicar un curso que no tiene módulos.");
        }
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourseById(id);
        
        // Regla de negocio: un curso no se puede hacer público si no tiene un módulo agregado
        if (Boolean.TRUE.equals(course.getIsPublished()) && 
            (existingCourse.getModulos() == null || existingCourse.getModulos().isEmpty())) {
            throw new IllegalArgumentException("No se puede publicar un curso que no tiene módulos.");
        }
        
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setImageUrl(course.getImageUrl());
        existingCourse.setCourseLevel(course.getCourseLevel());
        existingCourse.setIsPublished(course.getIsPublished());
        existingCourse.setStatus(course.getStatus());
        
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}