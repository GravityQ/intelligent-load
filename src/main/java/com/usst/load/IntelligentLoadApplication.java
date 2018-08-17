package com.usst.load;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.usst.load.dao")
public class IntelligentLoadApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligentLoadApplication.class, args);
	}
}
