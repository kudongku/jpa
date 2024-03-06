package me.dongku.jpa.thread;

import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.channel.ChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ThreadRepositoryTest {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ChannelRepository channelRepository;


    @Test
    void insertThread() {
        Channel channel = Channel.builder().name("new-group").build();
        Channel savedChannel = channelRepository.insertChannel(channel);

        Thread thread = Thread.builder().messeage("insertThreadTest").build();
        Thread thread2 = Thread.builder().messeage("insertThreadTest2").build();
        thread.setChannel(savedChannel);
        thread2.setChannel(savedChannel);

        Thread savedThread = threadRepository.insertThread(thread);
        Thread savedThread2 = threadRepository.insertThread(thread2);

        Channel foundChannel = channelRepository.selectChannel(savedChannel.getId());

        assert foundChannel.getThreads().containsAll(Set.of(savedThread, savedThread2));
    }

    @Test
    void deleteThreadWithOrphanRemoval() {
        //given
        Channel channel = Channel.builder().name("new-group").build();
        Thread thread = Thread.builder().messeage("insertThreadTest").build();
        Thread thread2 = Thread.builder().messeage("insertThreadTest2").build();
        thread.setChannel(channel);
        thread2.setChannel(channel);

        Channel savedChannel = channelRepository.insertChannel(channel);
        Thread savedThread = threadRepository.insertThread(thread);
        Thread savedThread2 = threadRepository.insertThread(thread2);

        //when
        Channel foundChannel = channelRepository.selectChannel(savedChannel.getId());
        foundChannel.getThreads().remove(savedThread);
    }
}