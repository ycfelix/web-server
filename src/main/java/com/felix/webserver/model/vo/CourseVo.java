package com.felix.webserver.model.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.felix.webserver.model.BaseEntity;
import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseVo{

    @Id
    private Long id;

    @Formula("(select GROUP_CONCAT(b.name order by b.name) from " +
            "student s LEFT JOIN book b on b.student_id = s.id where s.course_id = id)")
    private String books;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "course",orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Student> students;


}
