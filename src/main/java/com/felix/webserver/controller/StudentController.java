package com.felix.webserver.controller;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.customUpdate(student);
    }

    @GetMapping
    public List<Student> retrieve() {
        return studentRepository.findAll();
    }

}
