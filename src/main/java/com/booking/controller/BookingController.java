package com.booking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.entity.BookingEntity;
import com.booking.entity.UserEntity;
import com.booking.repository.UserRepository;
import com.booking.service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/bookings")
    public String listBookings(Model model, Authentication authentication) {
        String username = authentication.getName();
        UserEntity user = userRepository.findByUsername(username);
        model.addAttribute("bookings", user.getBookings());
        return "bookings";
    }

    @GetMapping("/user/book-room")
    public String bookRoomForm() {
        return "book-room";
    }

    @PostMapping("/user/book-room")
    public String bookRoom(@RequestParam("roomNumber") int roomNumber,
                           @RequestParam("checkIn") String checkIn,
                           @RequestParam("checkOut") String checkOut,
                           Authentication authentication, Model model) {
        String username = authentication.getName();
        UserEntity user = userRepository.findByUsername(username);

        BookingEntity booking = new BookingEntity();
        booking.setUser(user);
        booking.setRoomNumber(roomNumber);
        booking.setCheckIn(LocalDate.parse(checkIn));
        booking.setCheckOut(LocalDate.parse(checkOut));

        bookingService.save(booking);

        model.addAttribute("message", "Room booked successfully!");
        return "redirect:/user/bookings";
    }
}
