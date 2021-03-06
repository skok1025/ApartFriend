package com.twoplus.apartfriend;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import com.twoplus.apartfriend.libarary.libLog;

@EnableCaching
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // no database setting
public class BootApp {
	
	public static void main(String[] args) {
		// server 시작시간 로깅
		libLog.getInstance().write("server.log", "SERVER_START_TIME");
		SpringApplication.run(BootApp.class,args);
	}

}
