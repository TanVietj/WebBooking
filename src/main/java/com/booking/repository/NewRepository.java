package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}
