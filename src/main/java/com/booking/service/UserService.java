package com.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.entity.UserEntity;

@Service
public interface UserService {
    void save(UserEntity user);
    UserEntity findByUsername(String username);
    List<UserEntity> findAll();
    void delete(Long id);
}
