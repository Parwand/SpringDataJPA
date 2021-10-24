package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Course;
import net.parwand.springdatajpa.entity.Guardian;
import net.parwand.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {

    @Autowired
    private CourseService courseService;
    @Test
    void saveCourseTest() {
        Course course = Course.builder()
                .credit("1200")
                .title("Spring data JPA")
                .build();
        courseService.saveCourse(course);
    }

    @Test
    void saveCourseWithStudentsTest() {
        List<Student> students = List.of(
                Student.builder()
                        .email("lucas@school.de")
                        .firstname("lucas")
                        .lastname("mark")
                        .build(),
                Student.builder()
                        .email("alexa@school.de")
                        .firstname("alexa")
                        .lastname("sam")
                        .build()
        );
        Course course = Course.builder()
                .credit("1200")
                .title("Spring data JPA")
                .students(students)
                .build();
        courseService.saveCourse(course);
    }
}