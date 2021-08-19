package com.felix.webserver.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends AuditableDTO {

    Long id;

    String name;

    List<Student> students;

}
