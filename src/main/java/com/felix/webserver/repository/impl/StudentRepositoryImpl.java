package com.felix.webserver.repository.impl;

import com.felix.webserver.repository.model.StudentEntity;
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
    public StudentEntity customUpdate(StudentEntity student) {
        return entityManager.merge(student);
    }

}
