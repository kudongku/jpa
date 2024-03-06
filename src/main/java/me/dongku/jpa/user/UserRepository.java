package me.dongku.jpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.userChannel.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Channel, Long> {
}
