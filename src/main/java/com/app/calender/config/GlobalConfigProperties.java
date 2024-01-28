package com.app.calender.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "user")
public record GlobalConfigProperties(Integer phoneNo, String name){

}
