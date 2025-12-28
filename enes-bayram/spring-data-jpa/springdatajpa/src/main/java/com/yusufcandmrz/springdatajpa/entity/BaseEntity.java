package com.yusufcandmrz.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity<T> {

    private Boolean result;

    private String errorMessage;

    private T data;

    public static  <T> BaseEntity<T> ok(T data) {
        BaseEntity<T> baseEntity = new BaseEntity<>();
        baseEntity.setResult(true);
        baseEntity.setErrorMessage(null);
        baseEntity.setData(data);
        return baseEntity;
    }

    public static <T> BaseEntity<T> error(String errorMessage) {
        BaseEntity<T> baseEntity = new BaseEntity<>();
        baseEntity.setResult(false);
        baseEntity.setErrorMessage(errorMessage);
        baseEntity.setData(null);
        return baseEntity;
    }
}
