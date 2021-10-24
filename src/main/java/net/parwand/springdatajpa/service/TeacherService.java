package net.parwand.springdatajpa.service;

import net.parwand.springdatajpa.entity.Teacher;
import net.parwand.springdatajpa.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
}
