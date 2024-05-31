package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booking.entity.UserEntity;
import com.booking.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	  @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	UserEntity user = userRepository.findByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return User.withUsername(user.getUserName())
	                   .password(user.getPassword())
	                   .roles(user.getRole())
	                   .build();
	    }
 
}
