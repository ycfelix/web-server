package com.felix.webserver.controller;

import com.felix.webserver.model.vo.CourseView;
import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    CourseRepository courseRepository;

    @GetMapping
    public List<CourseVo> retrieveCourse(@RequestParam Long id) {
        return courseRepository.customRetrieve(id);
    }

    @GetMapping("/jpql")
    public List<CourseView> retrieveCourseJPQL(@RequestParam Long id) {
        var sort = Sort.by(Sort.Direction.ASC,"students");
        Pageable pageable = PageRequest.of(0,2,sort);
        return courseRepository.customRetrieveJPQL(id, pageable);
    }

}
