package com.felix.webserver.repository;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.vo.CourseVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<CourseVo> customRetrieve(Long id);

    @Query(value = "SELECT c.id, c.name from course c where c.id = ?1", nativeQuery = true)
    List<CourseVo> customRetrieveJPQL(Long id);
}
