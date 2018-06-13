package com.cen.dubboprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo/dubbo-provider.xml"})
public class DubboproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboproviderApplication.class, args);
	}
}
