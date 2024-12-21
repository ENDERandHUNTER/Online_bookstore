package com.hust.online_bookstore_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hust.online_bookstore_backend.mapper")
public class OnlineBookstoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookstoreBackendApplication.class, args);
	}

}
