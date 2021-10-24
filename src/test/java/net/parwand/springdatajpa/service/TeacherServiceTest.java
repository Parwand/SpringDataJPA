package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    void saveTeacherWithCourseAndCourseMaterialAndStudentsAndGuardian(){
        Guardian guardian1 = Guardian.builder()
                .name("leo")
                .email("leo@email.de")
                .mobile("+49159774148")
                .build();

        Guardian guardian2 = Guardian.builder()
                .name("chris")
                .email("chris@email.de")
                .mobile("+49552247788")
                .build();


        List<Student> students = List.of(
                Student.builder()
                        .email("messi@school.de")
                        .firstname("messi")
                        .lastname("leo")
                        .guardian(guardian1)
                        .build(),
                Student.builder()
                        .email("philip@school.de")
                        .firstname("philip")
                        .lastname("chris")
                        .guardian(guardian2)
                        .build()
        );


        Course course = Course.builder()
                .credit("1200")
                .title("Spring data JPA")
                .students(students)
                .build();

        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .course(course)
                .url("https://www.parwand.net")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Spring")
                .lastName("Boot")
                .courses(List.of(course))
                .build();
        teacherService.saveTeacher(teacher);
    }
}
