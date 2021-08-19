package com.felix.webserver.repository.model.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.felix.webserver.repository.model.StudentEntity;
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
public class CourseVoEntity {

    @Id
    private Long id;

    //solution without extra params
    @Formula("(select GROUP_CONCAT(b.name order by b.name) from " +
            "student s LEFT JOIN book b on b.student_id = s.id where s.course_id = id)")
    private String books;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "course",orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<StudentEntity> students;


}
