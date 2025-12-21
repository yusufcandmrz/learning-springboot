package com.yusufcandmrz.springdatajpa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "app")
public class ServerProperties {
    private List<Server> serverList;
}
