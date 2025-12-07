package com.yusufcandmrz.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Table(name = "student")
@Entity
@Getter
public class Student {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_of_date")
    private LocalDate birthOfDate;
}
