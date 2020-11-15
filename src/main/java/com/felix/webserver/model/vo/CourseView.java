package com.felix.webserver.model.vo;

import com.felix.webserver.model.Student;

import java.util.List;

public interface CourseView {
    Long getId();

    String getBooks();

    List<Student> getStudents();
}
