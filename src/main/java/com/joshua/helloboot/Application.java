package com.joshua.helloboot;

import com.joshua.config.MySpringBootApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApplication
@RequiredArgsConstructor
public class Application {

	private final JdbcTemplate jdbcTemplate;

	@PostConstruct // 어플리케이션이 실행되고나서 가장 먼저 동작하길 원할 때
	void init () {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

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
