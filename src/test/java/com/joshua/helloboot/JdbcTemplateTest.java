package com.joshua.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
//@Rollback (false)
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery () {
        jdbcTemplate.update("insert into hello values (?, ?)", "Joshua", 3);
        jdbcTemplate.update("insert into hello values (?, ?)", "Spring", 5);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }

    @Test
    void insertAndQuery2 () {
        jdbcTemplate.update("insert into hello values (?, ?)", "Joshua", 3);
        jdbcTemplate.update("insert into hello values (?, ?)", "Spring", 5);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    } // 이 테스트가 통과한다면 count 가 2개라는 것이고, 그 말은 첫번째 테스트가 롤백이되었다는 것이다. 롤백이 되지 않으면 4개임.
    // 별다른 설정을 하지 않는다면, 테스트에서의 트랜잭션은 rollback 이 기본 옵션이다.
    // 테스트 클래스에서 @Rollback (false) 를 통해 롤백을 막을 수 있다.

}
