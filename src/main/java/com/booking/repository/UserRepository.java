package com.booking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}

