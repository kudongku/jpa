package me.dongku.jpa.my;

import me.dongku.jpa.common.PageDto;
import me.dongku.jpa.user.User;
import me.dongku.jpa.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MyRepositoryImplTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void deleteUser() {
        User user = User.builder().username("test01").password("test01p").build();
        userRepository.save(user);

        userRepository.delete(user);
    }

    @Test
    public void findAllTest() {
        User user = User.builder().username("test01").password("test01p").build();
        userRepository.save(user);
        User user2 = User.builder().username("test01").password("test02p").build();
        userRepository.save(user2);

        var userNameList = userRepository.findByUsername("test01", Sort.by("customField"));

        Assertions.assertEquals(true, userNameList.containsAll(List.of(user, user2)));
    }

    @Test
    void pageDtoTest(){
        // given
        User user = User.builder().username("test01").password("test01p").build();
        userRepository.save(user);
        User user2 = User.builder().username("test02").password("test02p").build();
        userRepository.save(user2);
        User user3 = User.builder().username("test03").password("test03p").build();
        userRepository.save(user3);

        PageDto pageDto = new PageDto(2, 2, "password");

        // when
        Page<User> page = userRepository.findAll(pageDto.toPageable());

        // then
        assert page.getContent().size()==2;
    }
}