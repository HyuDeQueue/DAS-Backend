package com.project.DASBackend.service;

import com.project.DASBackend.dto.BookingSampleDto;

import java.util.List;

public interface BookingSampleService {
//    BookingSampleDto createBookingDetail(BookingSampleDto bookingSampleDto);
    BookingSampleDto getBookingDetailById(Integer bookingDetailId);
    List<BookingSampleDto> getAllBookingDetails();
    BookingSampleDto updateBookingDetail(Integer bookingDetailId, BookingSampleDto bookingSampleDto);
    void deleteBookingDetail(Integer bookingDetailId);
    void changeStatus(Integer bookingDetailId, Integer status);
}
