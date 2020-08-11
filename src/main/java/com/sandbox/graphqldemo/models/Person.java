package com.sandbox.graphqldemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
