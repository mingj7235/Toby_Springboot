package com.joshua.helloboot;

import java.util.Objects;

public class HelloController {
    // Spring Container 에 SimpleHelloService 를 Bean 으로 등록한다.
    // HelloController 에서 생성자를 통해 주입된 인터페이스인 HelloService 를 구현한 Bean 이 있는지 Spring 이 스캔을 하고, SimpleHelloService 의 sayHello 메소드를 수행한다.
    private final HelloService helloService;

    public HelloController(final HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello (String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
