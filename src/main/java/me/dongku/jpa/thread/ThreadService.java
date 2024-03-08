package me.dongku.jpa.thread;

import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.user.User;

import java.util.List;

public interface ThreadService {
    List<Thread> selectNotEmptyThreadList(Channel channel);

    Thread insert(Thread thread);
}
