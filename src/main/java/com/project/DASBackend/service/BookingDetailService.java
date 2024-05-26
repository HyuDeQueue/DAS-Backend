package com.project.DASBackend.service;

import com.project.DASBackend.dto.BookingDetailDto;

import java.util.List;

public interface BookingDetailService {
    BookingDetailDto createBookingDetail(BookingDetailDto bookingDetailDto);
    BookingDetailDto getBookingDetailById(Integer bookingDetailId);
    List<BookingDetailDto> getAllBookingDetails();
    BookingDetailDto updateBookingDetail(Integer bookingDetailId, BookingDetailDto bookingDetailDto);
    void deleteBookingDetail(Integer bookingDetailId);
}
