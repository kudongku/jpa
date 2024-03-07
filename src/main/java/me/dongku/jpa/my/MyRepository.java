package me.dongku.jpa.my;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<User, ID extends Serializable> extends Repository<User, ID> {

    User save(User entity);

    Optional<User> findByUsername(String username);

    List<User> findAll();

}
