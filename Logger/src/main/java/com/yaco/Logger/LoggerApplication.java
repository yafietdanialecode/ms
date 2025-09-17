package com.yaco.Logger;

import java.util.List;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.provider.HibernateUtils;

import com.yaco.Logger.Models.User;

@SpringBootApplication
public class LoggerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LoggerApplication.class, args);
	}

}
