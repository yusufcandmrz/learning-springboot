package com.yusufcandmrz.springdatajpa.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record ErrorResponse(LocalDateTime timestamp, int status, Map<String, List<String>> errorMap) {
}
