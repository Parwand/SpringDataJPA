package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Guardian;
import net.parwand.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void saveStudent1() {
        Guardian guardian = Guardian
                .builder()
                .name("Moller")
                .email("Moller@email.de")
                .mobile("+49 16832241975")
                .build();
        Student student = Student
                .builder()
                .firstname("Lea")
                .lastname("Moller")
                .email("lea@school.de")
                .guardian(guardian)
                .build();

        studentService.saveStudent(student);
    }
    @Test
    void saveStudent2() {
        Guardian guardian = Guardian
                .builder()
                .name("Sebastian")
                .email("Sebastian@email.de")
                .mobile("+4914578854796")
                .build();
        Student student = Student
                .builder()
                .firstname("Sia")
                .lastname("Sebastian")
                .email("sia@school.de")
                .guardian(guardian)
                .build();

        studentService.saveStudent(student);
    }

    @Test
    void AllShouldStudentInDB(){
        List<Student> students = studentService.findAll();
        assertThat(students.size()).isEqualTo(2);
    }
    @Test
    void findStudentByEmailTest(){
        Student student = studentService.findStudentByEmail("sia@school.de");
        assertThat(student.getEmail()).isEqualTo("sia@school.de");
    }

    @Test
    void findStudentByGuardianNameTest(){
        Guardian guardian = Guardian
                .builder()
                .name("Sebastian")
                .email("Sebastian@email.de")
                .mobile("+4914578854796")
                .build();
        Student student = studentService.findStudentByGuardianName(guardian);
        assertThat(student.getGuardian().getName()).isEqualTo("Sebastian");
    }

    @Test
    void findStudentByEmailWithNativeTest(){
        Student student = studentService.findStudentByEmailWithNative("sia@school.de");
        assertThat(student.getEmail()).isEqualTo("sia@school.de");
    }

    @Test
    void findStudentByFirstnameAndLastNameTest(){
        Student student = studentService.findStudentByFirstnameAndLastName("lea", "moller");
        assertThat(student.getFirstname()).isEqualTo("Lea");
        assertThat(student.getLastname()).isEqualTo("Moller");
    }
}