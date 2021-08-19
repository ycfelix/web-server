package com.felix.webserver.service;

import com.felix.webserver.model.Course;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.model.vo.CourseViewEntity;
import com.felix.webserver.repository.model.vo.CourseVoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ObjectConversionService objectConversionService;

    @Cacheable(value="CourseVo", key="#root.target.test+#p0")
    public List<Course> retrieveCourse(List<Long> id) {
        var courses = courseRepository.customRetrieve(id.get(0));
        return courses.stream().map(e -> objectConversionService.convert(e)).collect(Collectors.toList());
    }

    public List<Course> retrieveCourseJPQL(Long id) {
        var sort = Sort.by(Sort.Direction.ASC,"students");
        Pageable pageable = PageRequest.of(0,2,sort);
        var courses = courseRepository.customRetrieveJPQL(id, pageable);
        return courses.stream().map(e -> objectConversionService.convert(e)).collect(Collectors.toList());
    }
}
