package com.joshua.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext(); // Spring Container
		applicationContext.registerBean(HelloController.class); // Bean 등록
		applicationContext.refresh(); // Spring Container 가 본인이 가지고 있는 Configuration Metadata 를 통해 컨테이너를 초기화 하는 작업. -> Bean Object 를 만들어준다.

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {

			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
					// 인증, 보안, 다국어처리, 각종 공통 기능 (구현했다고 치고)
					if (req.getRequestURI().equals("/hello") &&  req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);// 등록한 Bean 을 가져온다. 가져오기만 하면된다.
						String result = helloController.hello(name); // 복잡한 비지니스 로직은 여기에 위임

						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(result);
					}
					else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
		webServer.start();
	}

}
