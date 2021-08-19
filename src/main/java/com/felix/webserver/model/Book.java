package com.felix.webserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends AuditableDTO implements Serializable {

    Long id;

    String name;

    Student student;

    Long price;
}
