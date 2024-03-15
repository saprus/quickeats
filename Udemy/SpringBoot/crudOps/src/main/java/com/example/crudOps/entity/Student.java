package com.example.crudOps.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String firstName;
    private String lastName;


}
