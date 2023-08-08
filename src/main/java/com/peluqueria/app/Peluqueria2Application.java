package com.peluqueria.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.peluqueria.app")
public class Peluqueria2Application {

	public static void main(String[] args) {
		SpringApplication.run(Peluqueria2Application.class, args);
	}

}
