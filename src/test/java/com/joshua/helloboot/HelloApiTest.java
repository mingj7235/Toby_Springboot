package com.joshua.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // Test 를 실행할 때 Tomcat 을 띄워서 테스크하도록. 즉, 어플리케이션을 미리 실행하지 않아도 테스트가능
public class HelloApiTest {
    @Test
    void helloApi () {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // 응답 검증
        // status 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        // header(content-type) text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        // body Hello Spring
        assertThat(res.getBody()).isEqualTo("Decorator ** Hello Spring");
    }

    @Test
    void failsHelloApi () {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        // 응답 검증
        // status 500
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
