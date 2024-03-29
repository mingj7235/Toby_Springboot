package com.joshua.helloboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleHelloService implements HelloService {

    private final HelloRepository helloRepository;

    @Override
    public String sayHello(String name) {

        this.helloRepository.increaseCount(name);

        return "Hello " + name;
    }

    @Override
    public Integer countOf(final String name) {
        return helloRepository.countOf(name);
    }

}
