package com.felix.webserver.model.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.felix.webserver.model.BaseEntity;
import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseVo{

    public CourseVo(Long id){
        this.id = id;
    }

    @Id
    private Long id;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "course",orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Student> students;

//    @Transient
//    private  String[] bookNames;
}
