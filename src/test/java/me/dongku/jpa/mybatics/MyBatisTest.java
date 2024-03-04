package me.dongku.jpa.mybatics;

import me.dongku.jpa.mybatics.configuration.DBConfiguration;
import me.dongku.jpa.mybatics.mapper.AccountMapper;
import me.dongku.jpa.mybatics.mapper.AccountMapperV2;
import me.dongku.jpa.mybatics.vo.AccountMyBatisVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DBConfiguration.class)
public class MyBatisTest {
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccountMapperV2 accountMapperV2;

    @Test
    @DisplayName("SQL Mapper - MyBatis 실습 (XML)")
    void sqlMapper_MyBatisTest() {
        // given

        // when
        accountMapper.insertAccount(new AccountMyBatisVO("new user3", "new password3"));
        var account = accountMapper.selectAccount(1);

        // then
        assert !account.getUsername().isEmpty();
    }

    @Test
    @DisplayName("SQL Mapper - MyBatis V2 실습")
    void sqlMapper_MyBatisV2Test() {
        // given

        // when
        accountMapperV2.insertAccount(new AccountMyBatisVO("new user4", "new password4"));
        var account = accountMapperV2.selectAccount(1);

        // then
        assert !account.getUsername().isEmpty();
    }
}
