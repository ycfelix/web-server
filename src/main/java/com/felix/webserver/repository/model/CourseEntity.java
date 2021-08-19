package com.felix.webserver.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CourseEntity extends AuditableEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "course",orphanRemoval = true, cascade = {CascadeType.ALL})
    List<StudentEntity> students;

//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return obj.hashCode()==this.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(id);
//    }
}
