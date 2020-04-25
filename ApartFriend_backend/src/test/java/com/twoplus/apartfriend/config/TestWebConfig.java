package com.twoplus.apartfriend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan({ "com.twoplus.apartfriend.controller"})
@Import({TestMVCConfig.class})
public class TestWebConfig{
	
}
