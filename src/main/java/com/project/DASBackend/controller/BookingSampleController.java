package com.project.DASBackend.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.DASBackend.dto.BookingSampleDto;
import com.project.DASBackend.service.BookingSampleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/bookingsamples")
public class BookingSampleController {

    private BookingSampleService bookingSampleService;

//    @PostMapping
//    public ResponseEntity<BookingSampleDto> createBookingDetail(@RequestBody BookingSampleDto bookingSampleDto) {
//        BookingSampleDto savedBookingDetail = bookingSampleService.createBookingDetail(bookingSampleDto);
//        return new ResponseEntity<>(savedBookingDetail, HttpStatus.CREATED);
//    }

    @GetMapping("{id}")
    public ResponseEntity<BookingSampleDto> getBookingDetailById(@PathVariable("id") Integer bookingDetailId) {
        BookingSampleDto bookingSampleDto = bookingSampleService.getBookingDetailById(bookingDetailId);
        return ResponseEntity.ok(bookingSampleDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingSampleDto>> getAllBookingDetails() {
        List<BookingSampleDto> bookingSampleDto = bookingSampleService.getAllBookingDetails();
        return ResponseEntity.ok(bookingSampleDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookingSampleDto> updateBookingDetail(@Valid @RequestBody BookingSampleDto bookingSampleDto,
                                                                @PathVariable("id") Integer bookingDetailId) {
        BookingSampleDto updatedBookingDetail = bookingSampleService.updateBookingDetail(bookingDetailId, bookingSampleDto);
        return ResponseEntity.ok(updatedBookingDetail);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookingDetail(@PathVariable("id") Integer bookingDetailId) {
        bookingSampleService.deleteBookingDetail(bookingDetailId);
        return ResponseEntity.ok("Booking detail deleted successfully");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> changeBookingSampleStatus(@PathVariable("id") Integer bookingSampleId, @RequestParam("status") Integer status) {
        bookingSampleService.changeStatus(bookingSampleId, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byBooking/{bookingId}")
    public ResponseEntity<List<BookingSampleDto>> getBookingSamplesByBookingId(@PathVariable("bookingId") Integer bookingId) {
        List<BookingSampleDto> bookingSampleDtos = bookingSampleService.getBookingSamplesByBookingId(bookingId);
        return ResponseEntity.ok(bookingSampleDtos);
    }
}
