package me.dongku.jpa.thread;

import com.mysema.commons.lang.IteratorAdapter;
import jakarta.persistence.criteria.Predicate;
import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    ThreadRepository threadRepository;

    @Override
    public List<Thread> selectNotEmptyThreadList(Channel channel) {
        var thread = QThread.thread;

        // 메세지가 비어있지 않은 해당 채널의 쓰레드 목록
        var predicate = thread.channel
                .eq(channel)
                .and(thread.message.isNotEmpty());

        var threads = threadRepository.findAll(predicate);

        return IteratorAdapter.asList(threads.iterator());
    }

    @Override
    public Thread insert(Thread thread) {
        return threadRepository.save(thread);
    }
}