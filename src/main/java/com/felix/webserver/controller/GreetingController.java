package com.felix.webserver.controller;

import com.felix.webserver.model.Book;
import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/book")
    public Student removeBook(@RequestParam(required = false) String name) {
        var student = studentRepository.findById(4L).get();
        var book = student.getBooks().get(0);
        student.getBooks().remove(book);
        return studentRepository.save(student);
    }

    @GetMapping("/course")
    public Course removeStudent(@RequestParam(required = false) Long id) {
        var course = courseRepository.findById(id).get();
        var student = studentRepository.findById(4L).get();
        course.getStudents().remove(student);
        return courseRepository.save(course);
    }
}
