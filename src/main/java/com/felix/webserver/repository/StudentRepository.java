package com.felix.webserver.repository;

import com.felix.webserver.repository.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity customUpdate(StudentEntity student);
}
