package com.joshua.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class Application {
	@Bean
	public HelloController helloController (HelloService helloService) {
		return new HelloController(helloService);
	}
	@Bean
	public HelloService helloService () {
		return new SimpleHelloService();
	}

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() { // onRefresh 는 Spring Container 가 초기화 되는 도중에 진행되도록 하는 메소드다.
				super.onRefresh();
				// Spring Container 가 초기화 될 때, Dispatcher Servlet 을 생성하도록 하는 것.
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this)
					).addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.register(Application.class);
		applicationContext.refresh();
	}
}
