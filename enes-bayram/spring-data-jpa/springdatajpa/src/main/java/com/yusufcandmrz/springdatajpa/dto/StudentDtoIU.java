package com.yusufcandmrz.springdatajpa.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoIU {

    @NotBlank
    private String fullName;

    private LocalDate birthOfDate;

    @Email
    @NotBlank
    private String email;

    @Size(min = 11, max = 11)
    @NotBlank
    private String identityNumber;

    private Integer departmentId;
}
