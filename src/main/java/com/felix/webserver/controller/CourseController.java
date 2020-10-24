package com.felix.webserver.controller;

import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<CourseVo> retrieveCourse(@RequestParam Long id) {
        return courseRepository.customRetrieve(id);
    }
}
