package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.BookingEntity;
import com.booking.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public List<BookingEntity> findAll() {
		return bookingRepository.findAll();
	}

	public BookingEntity save(BookingEntity booking) {
		return bookingRepository.save(booking);
	}

//    public BookingEntity findById(Long id) {
//        return bookingRepository.findById(id).orElse(null);
//    }

	public void deleteById(Long id) {
        bookingRepository.delete(id);
    }
}
