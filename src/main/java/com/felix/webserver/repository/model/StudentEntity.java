package com.felix.webserver.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "courseId")
    CourseEntity course;

    @JsonManagedReference
    @OneToMany(mappedBy = "student",orphanRemoval = true, cascade = {CascadeType.ALL})
    List<BookEntity> bookEntities;

}
