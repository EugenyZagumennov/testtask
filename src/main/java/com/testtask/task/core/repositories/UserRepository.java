package com.testtask.task.core.repositories;

import com.testtask.task.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa Repository for User entities
 *
 * @author Evgeniy Zagumennov
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
