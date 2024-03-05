package me.dongku.jpa.channel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ChannelRepositoryTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    void insertSelectChannel() {
        Channel channel = Channel.builder().name("new-group").build();

        Channel savedChannel = channelRepository.insertChannel(channel);

        Channel foundChannel = channelRepository.selectChannel(savedChannel.getId());

        assert foundChannel.getId().equals(savedChannel.getId());
    }
}