package com.felix.webserver.controller;

import com.felix.webserver.model.Course;
import com.felix.webserver.repository.model.vo.CourseViewEntity;
import com.felix.webserver.repository.model.vo.CourseVoEntity;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<Course> retrieveCourse(@RequestParam List<Long> ids) {
        return courseService.retrieveCourse(ids);
    }

    @GetMapping("/jpql")
    public List<Course> retrieveCourseJPQL(@RequestParam Long id) {
        return courseService.retrieveCourseJPQL(id);
    }

}
