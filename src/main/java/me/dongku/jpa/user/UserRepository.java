package me.dongku.jpa.user;

import me.dongku.jpa.my.MyRepository;
import me.dongku.jpa.my.MyRepositoryImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
@Query("SELECT u, u.password AS customField FROM User u WHERE u.username = ?1")
    List<User> findByUsername (String username, Sort sort);
}
