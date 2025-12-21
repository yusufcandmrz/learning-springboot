package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.config.DataSource;
import com.yusufcandmrz.springdatajpa.config.DataSourceProperties;
import com.yusufcandmrz.springdatajpa.config.Server;
import com.yusufcandmrz.springdatajpa.config.ServerProperties;
import com.yusufcandmrz.springdatajpa.controller.PropertyController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyControllerImpl implements PropertyController {

    DataSourceProperties dataSourceProperties;
    ServerProperties serverProperties;

    public PropertyControllerImpl(DataSourceProperties dataSourceProperties, ServerProperties serverProperties) {
        this.dataSourceProperties = dataSourceProperties;
        this.serverProperties = serverProperties;
    }

    @Override
    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;
    }

    @Override
    @GetMapping("/server")
    public List<Server> getServerList() {
        return serverProperties.getServerList();
    }
}
