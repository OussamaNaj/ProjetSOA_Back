package com.soa.student_service.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.soa.student_service.model.Student;
import com.soa.student_service.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentSerivce {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentSerivce(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student CUStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int cin) {
        studentRepository.deleteById(cin);
    }

    public Student getStudent(int cin) {
        return studentRepository.getById(cin);
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

}
