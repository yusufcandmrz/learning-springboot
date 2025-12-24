package com.yusufcandmrz.springdatajpa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException<T> {

    private LocalDateTime timestamp;
    private int status;
    private T message;
    private String path;
}
