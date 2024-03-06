package me.dongku.jpa.userChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.dongku.jpa.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends JpaRepository<Channel, Long> {
}
