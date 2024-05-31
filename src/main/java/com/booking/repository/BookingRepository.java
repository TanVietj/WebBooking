package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    // Các phương thức tùy chỉnh (nếu cần)
}