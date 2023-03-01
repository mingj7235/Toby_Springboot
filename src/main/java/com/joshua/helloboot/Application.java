package com.joshua.helloboot;

import com.joshua.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class Application {

//	@Bean
//	ApplicationRunner applicationRunner (Environment env) {
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name: " + name);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
