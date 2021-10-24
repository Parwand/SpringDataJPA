package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Course;
import net.parwand.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialServiceTest {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @Test
    void saveCourseMaterialWithCourseTest() {
        Course course = Course.builder()
                .title("Spring JDBC")
                .credit("300")
                .build();

        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("https://www.parwand.net")
                .course(course)
                .build();

        courseMaterialService.saveCourseMaterial(courseMaterial);
    }
}