package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Guardian;
import net.parwand.springdatajpa.entity.Student;
import net.parwand.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    public Student findStudentByGuardianName(Guardian guardian){
        return studentRepository.findStudentByGuardianName(guardian);
    }

    public Student findStudentByEmailWithNative(String email){
        return studentRepository.findStudentByEmailsWithNative(email);
    }

    public Student findStudentByFirstnameAndLastName(String firstname, String lastName){
        return studentRepository.findStudentByFirstnameAndLastName(firstname, lastName);
    }
}
