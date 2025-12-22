package com.yusufcandmrz.springdatajpa.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    STUDENT_NOT_FOUND("1001", "Student not found"),
    STUDENT_ALREADY_HAS_A_PROFILE("1002", "Student already has a profile"),

    DEPARTMENT_NOT_FOUND("2001", "Department not found"),

    COURSE_NOT_FOUND("3001", "Course not found");

    private final String code;
    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
