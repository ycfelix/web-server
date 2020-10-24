package com.felix.webserver.repository;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.vo.CourseVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<CourseVo> customRetrieve(Long bookId);
}
