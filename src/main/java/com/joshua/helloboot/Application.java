package com.joshua.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
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
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {

			HelloController helloController = new HelloController();

			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
					// 인증, 보안, 다국어처리, 각종 공통 기능 (구현했다고 치고)

					if (req.getRequestURI().equals("/hello") &&  req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");

						String result = helloController.hello(name); // 복잡한 비지니스 로직은 여기에 위임

						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(result);
					}
					if (req.getRequestURI().equals("/hello") &&  req.getMethod().equals(HttpMethod.POST.name())) {
						// post
					}

					else if (req.getRequestURI().equals("/user")) {
						// code for /user
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
