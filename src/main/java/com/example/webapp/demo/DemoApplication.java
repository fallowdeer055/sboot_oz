package com.example.webapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		TagRepo tagRepo = context.getBean(TagRepo.class);
		tagRepo.saveAll(Arrays.asList(
				new Tag(null, "tag01"),
				new Tag(null, "tag02"),
				new Tag(null, "tag03"),
				new Tag(null, "tag04"),
				new Tag(null, "tag05"),
				new Tag(null, "tag06")
		));

		System.out.println("Values inserted");
	}

}
