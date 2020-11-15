package com.felix.webserver.controller;

import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.CourseRepository;
import org.hibernate.EmptyInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<CourseVo> retrieveCourse(@RequestParam Long id) {
        return courseRepository.customRetrieve(id);
    }
    @GetMapping("/jpql")
    public List<CourseVo> retrieveCourseJPQL(@RequestParam Long id) {
        return courseRepository.customRetrieveJPQL(id);
    }

}
