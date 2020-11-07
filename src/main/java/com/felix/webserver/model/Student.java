package com.felix.webserver.model;

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
public class Student extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

    @JsonManagedReference
    @OneToMany(mappedBy = "student",orphanRemoval = true, cascade = {CascadeType.ALL})
    List<Book> books;

}
