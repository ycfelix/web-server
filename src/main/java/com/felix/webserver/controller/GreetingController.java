package com.felix.webserver.controller;

import com.felix.webserver.model.Student;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/test")
    public Student greeting(@RequestParam(required = false) String name) {
        return studentRepository.findById(1L).orElse(new Student());
    }
}
