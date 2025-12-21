package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.config.DataSource;
import com.yusufcandmrz.springdatajpa.config.Server;

import java.util.List;

public interface PropertyController {

    public DataSource getDataSource();

    public List<Server> getServerList();
}