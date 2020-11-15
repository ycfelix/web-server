package com.felix.webserver.repository;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.vo.CourseView;
import com.felix.webserver.model.vo.CourseVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<CourseVo> customRetrieve(Long id);

    //ultimate solution, need to test if sorting is possible
    @Query(value = "SELECT c.id, GROUP_CONCAT(s.name) as students from course c LEFT JOIN student s on s.course_id = c.id group by c.id",
            countQuery = "SELECT count(1) from course c LEFT JOIN student s on s.course_id = c.id group by c.id", nativeQuery = true)
    List<CourseView> customRetrieveJPQL(Long id, Pageable pageable);
}
