package com.hbgc.loudbbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapper 扫描
@MapperScan("com.hbgc.loudbbs.loudbbs.mapper")
public class LoudbbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoudbbsApplication.class, args);
	}

}
