package com.joshua.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService(helloRepositorySub);

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    private static HelloRepository helloRepositorySub =  new HelloRepository() {
        @Override
        public Hello findHello(final String name) {
            return null;
        }

        @Override
        public void increaseCount(final String name) {

        }
    };

    @Test
    void helloDecorator() {
        HelloDecorator decorated = new HelloDecorator(name -> name);

        String ret = decorated.sayHello("test");

        Assertions.assertThat(ret).isEqualTo("Decorator ** test");
    }

}
