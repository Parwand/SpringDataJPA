package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Course;
import net.parwand.springdatajpa.entity.Student;
import net.parwand.springdatajpa.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void saveCourse(Course course){
        repository.save(course);
    }
}
