package me.dongku.jpa.my;

import jakarta.persistence.EntityManager;
import me.dongku.jpa.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MyRepositoryImpl implements MyRepository<User> {

    @Autowired
    EntityManager entityManager;

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<String> findNameAll() {
        return entityManager.createQuery("SELECT u.username FROM User AS u", String.class).getResultList();

    }
}
