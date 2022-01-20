package com.soa.student_service.contoller;

import java.util.ArrayList;
import java.util.List;

import com.soa.student_service.model.Student;
import com.soa.student_service.service.StudentSerivce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentSerivce studentSerivce;

    public StudentController(StudentSerivce studentSerivce) {
        this.studentSerivce = studentSerivce;
    }

    @GetMapping("/getStudent/{cin}")
    public ResponseEntity<Student> getStudent(@PathVariable("cin") int cin) {
        Student s = studentSerivce.getStudent(cin);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> CUStudent(@RequestBody Student student) {
        Student s = studentSerivce.CUStudent(student);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{cin}")
    public ResponseEntity<?> deleteStudent(@PathVariable("cin") int cin) {
        studentSerivce.deleteStudent(cin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/StudentList")
    public ResponseEntity<List<Student>> getAllStudents() {
        ArrayList<Student> stuednList = studentSerivce.getAllStudents();
        return new ResponseEntity<>(stuednList, HttpStatus.OK);
    }

}
