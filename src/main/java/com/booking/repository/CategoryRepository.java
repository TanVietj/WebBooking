package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
