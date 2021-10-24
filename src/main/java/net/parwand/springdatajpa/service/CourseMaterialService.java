package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.CourseMaterial;
import net.parwand.springdatajpa.repository.CourseMaterialRepository;
import net.parwand.springdatajpa.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialService {
    private final CourseMaterialRepository repository;

    public CourseMaterialService(CourseMaterialRepository repository) {
        this.repository = repository;
    }

    public void saveCourseMaterial(CourseMaterial courseMaterial){
        repository.save(courseMaterial);
    }
}
