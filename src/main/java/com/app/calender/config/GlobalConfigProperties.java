package com.app.calender.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "user")
//@EnableConfigurationProperties(GlobalConfigProperties.class)
public record GlobalConfigProperties(Integer phoneNo, String name){

}
