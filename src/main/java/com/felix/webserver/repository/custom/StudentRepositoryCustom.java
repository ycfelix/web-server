package com.felix.webserver.repository.custom;

import com.felix.webserver.model.Student;
import com.felix.webserver.model.vo.CourseVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepositoryCustom {

    Student customUpdate(Student student);
}
