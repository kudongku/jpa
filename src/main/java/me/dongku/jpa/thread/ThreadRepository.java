package me.dongku.jpa.thread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ThreadRepository extends JpaRepository<Thread, Long>,
        QuerydslPredicateExecutor<Thread> {

}