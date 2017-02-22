package com.e451;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SourceFilesApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourceFilesApiServiceApplication.class, args);
	}
}
