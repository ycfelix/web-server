package com.felix.webserver.repository.custom;

import com.felix.webserver.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryCustom {

    Student customUpdate(Student student);
}
