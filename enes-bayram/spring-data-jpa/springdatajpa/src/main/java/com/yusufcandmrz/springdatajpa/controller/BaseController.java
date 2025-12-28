package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.entity.BaseEntity;

public class BaseController {

    public <T> BaseEntity<T> ok(T data) {
        return BaseEntity.ok(data);
    }

    public <T> BaseEntity<T> error(String errorMessage) {
        return BaseEntity.error(errorMessage);
    }
}
