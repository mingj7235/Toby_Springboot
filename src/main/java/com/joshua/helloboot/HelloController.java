package com.joshua.helloboot;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(final HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello (String name) {

        if (!StringUtils.hasText(name)) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
}
