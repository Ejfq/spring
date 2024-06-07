package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")// bean마다 @mapper 필요없어짐
public class Boot03Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot03Application.class, args);
	}

}
