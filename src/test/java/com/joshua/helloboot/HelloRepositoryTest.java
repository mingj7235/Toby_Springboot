package com.joshua.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class HelloRepositoryTest {

    @Autowired HelloRepository helloRepository;
    @Autowired JdbcTemplate jdbcTemplate;



    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Joshua")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Joshua")).isEqualTo(0);

        helloRepository.increaseCount("Joshua");
        assertThat(helloRepository.countOf("Joshua")).isEqualTo(1);

        helloRepository.increaseCount("Joshua");
        assertThat(helloRepository.countOf("Joshua")).isEqualTo(2);
    }

}



















