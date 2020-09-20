package com.felix.webserver.controller;

import com.felix.webserver.model.Book;
import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/student")
    public Student getStudent(@RequestParam Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    @DeleteMapping("/remove")
    public Course removeStudent(@RequestParam Long id) {
        var course = courseRepository.findById(id).get();
        var student = studentRepository.findById(4L).get();
        course.getStudents().remove(student);
        return courseRepository.save(course);
    }
}
