package com.joshua.helloboot;

public interface HelloService {
    String sayHello(String name);

    default Integer countOf(String name) {
        return 0;
    }

}
