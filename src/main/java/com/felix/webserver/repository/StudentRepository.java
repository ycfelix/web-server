package com.felix.webserver.repository;

import com.felix.webserver.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student customUpdate(Student student);
}
