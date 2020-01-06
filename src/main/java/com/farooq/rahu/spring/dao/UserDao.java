package com.farooq.rahu.spring.dao;

import com.farooq.rahu.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
