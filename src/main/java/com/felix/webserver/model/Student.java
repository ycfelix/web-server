package com.felix.webserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @JsonManagedReference
    @OneToMany(mappedBy = "student",orphanRemoval = true, cascade = {CascadeType.ALL})
    List<Book> books;

}
