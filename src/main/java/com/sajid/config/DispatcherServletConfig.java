package com.sajid.config;

import lombok.var;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@Configuration
@EnableWebMvc
@ComponentScan("com.sajid.*")
@PropertySource("classpath:application.properties")
public class DispatcherServletConfig {

}
