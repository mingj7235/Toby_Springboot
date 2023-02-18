package com.joshua.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorated = new HelloDecorator(name -> name);

        String ret = decorated.sayHello("test");

        Assertions.assertThat(ret).isEqualTo("Decorator ** test");
    }

}
