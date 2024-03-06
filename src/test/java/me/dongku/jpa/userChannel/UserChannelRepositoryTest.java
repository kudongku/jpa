package me.dongku.jpa.userChannel;

import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.channel.ChannelRepository;
import me.dongku.jpa.user.User;
import me.dongku.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserChannelRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;


    @Test
    void insertSelectUserChannel() {
        User user = User.builder().username("test01").password("test01").build();
        Channel channel = Channel.builder().name("testChannel").build();
        UserChannel userChannel = channel.addUser(user);

        userRepository.insertUser(user);
        channelRepository.insertChannel(channel);
        UserChannel savedUserChannel = userChannelRepository.insertUserChannel(userChannel);

    }

}