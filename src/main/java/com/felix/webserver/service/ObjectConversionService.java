package com.felix.webserver.service;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import com.felix.webserver.repository.model.StudentEntity;
import com.felix.webserver.repository.model.vo.CourseViewEntity;
import com.felix.webserver.repository.model.vo.CourseVoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ObjectConversionService {

    @Autowired
    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public Course convert(CourseVoEntity entity) {
        return modelMapper.map(entity, Course.class);
    }

    public Course convert(CourseViewEntity entity) {
        return modelMapper.map(entity, Course.class);
    }

    public Student convert(StudentEntity entity) {
        return modelMapper.map(entity, Student.class);
    }

    public StudentEntity convert(Student target) {
        return modelMapper.map(target, StudentEntity.class);
    }
}
