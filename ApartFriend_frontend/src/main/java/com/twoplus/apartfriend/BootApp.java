package com.twoplus.apartfriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // no database setting
// front boot
public class BootApp {
	
	public static void main(String[] args) {
		SpringApplication.run(BootApp.class,args);
	}

}
