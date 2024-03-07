package me.dongku.jpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.userChannel.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository {
    Optional<User> findByUsername (String username);
}
