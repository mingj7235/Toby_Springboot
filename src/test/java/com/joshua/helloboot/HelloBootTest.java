package com.joshua.helloboot;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class) // Bean 정보를 끌어오는 시작점이 되는 클래스를 지정. 이렇게 Bean 을 가지고와서 테스트에 사용할 수 있도록 함
@TestPropertySource("classpath:/application.properties") // Test 를 실행하는 동안 application.properties 의 구성정보를 가지고 올 수 있도록 설정을 함
@Transactional
public @interface HelloBootTest {

}
