package com.joshua.helloboot;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf (String name) {
        Hello hello = findHello(name);

        return hello == null ? 0 : hello.getCount();

    } // default 메소드 사용법? interface 에서 메소드를 사용하는 방법. 잘 활용하면 매우 유용
    // ref : Comparator 인터페이스 클래스 를 뜯어보면 재밌는게 많음
}
