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

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserChannelRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;
    @Test
    void insertSelectUserChannel() {
        User user = User.builder().username("test01").password("test01").build();
        Channel channel = Channel.builder().name("testChannel").build();
        UserChannel userChannel = channel.joinUser(savedUser);

        Optional<User> savedUser = userRepository.findByUsername(user.getUsername());
        Channel savedChannel = channelRepository.insertChannel(channel);
        Channel foundChannel = channelRepository.selectChannel(savedChannel.getId());
    }

    @Test
    void insertSelectUserChannelWithCascadeTest() {
        User user = User.builder().username("test01").password("test01").build();
        Channel channel = Channel.builder().name("testChannel").build();

        Channel savedChannel = channelRepository.insertChannel(channel);
        User savedUser = userRepository.insertUser(user);

        Channel foundChannel = channelRepository.selectChannel(savedChannel.getId());

    }
}