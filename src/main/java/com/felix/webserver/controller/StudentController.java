package com.felix.webserver.controller;

import com.felix.webserver.model.Student;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.customUpdate(student);
    }


}
