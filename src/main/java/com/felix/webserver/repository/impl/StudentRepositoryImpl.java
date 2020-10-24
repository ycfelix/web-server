package com.felix.webserver.repository.impl;

import com.felix.webserver.model.Student;
import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.custom.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class StudentRepositoryImpl implements StudentRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Modifying
    @Transactional
    public Student customUpdate(Student student) {
        return entityManager.merge(student);
    }

}
