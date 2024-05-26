package com.project.DASBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.DASBackend.dto.BookingDetailDto;
import com.project.DASBackend.service.BookingDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookingDetails")
public class BookingDetailController{

    private BookingDetailService bookingDetailService;

    @PostMapping
    public ResponseEntity<BookingDetailDto> createBookingDetail(@RequestBody BookingDetailDto bookingDetailDto) {
        BookingDetailDto savedBookingDetail = bookingDetailService.createBookingDetail(bookingDetailDto);
        return new ResponseEntity<>(savedBookingDetail, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDetailDto> getBookingDetailById(@PathVariable("id") Integer bookingDetailId) {
        BookingDetailDto bookingDetailDto = bookingDetailService.getBookingDetailById(bookingDetailId);
        return ResponseEntity.ok(bookingDetailDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingDetailDto>> getAllBookingDetails() {
        List<BookingDetailDto> bookingDetailDto = bookingDetailService.getAllBookingDetails();
        return ResponseEntity.ok(bookingDetailDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookingDetailDto> updateBookingDetail(@RequestBody BookingDetailDto bookingDetailDto,
                                                                @PathVariable("id") Integer bookingDetailId) {
        BookingDetailDto updatedBookingDetail = bookingDetailService.updateBookingDetail(bookingDetailId, bookingDetailDto);
        return ResponseEntity.ok(updatedBookingDetail);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookingDetail(@PathVariable("id") Integer bookingDetailId) {
        bookingDetailService.deleteBookingDetail(bookingDetailId);
        return ResponseEntity.ok("Booking detail deleted successfully");
    }
}
