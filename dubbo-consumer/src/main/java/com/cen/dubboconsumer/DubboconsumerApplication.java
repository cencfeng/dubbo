package com.cen.dubboconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@ImportResource({"classpath:dubbo/dubbo-consumer.xml"})
public class DubboconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboconsumerApplication.class, args);
	}
}
