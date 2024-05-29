package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentBookingDto;
import com.project.DASBackend.dto.BookingSampleDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.BookingSample;

import java.util.List;
import java.util.stream.Collectors;

public class AssessmentBookingMapper {
    public static AssessmentBookingDto toDto(AssessmentBooking booking) {
        if (booking == null) {
            return null;
        }
        List<BookingSampleDto> bookingSamples = booking.getBookingSamples().stream()
                .map(BookingSampleMapper::toDto)
                .collect(Collectors.toList());
        return new AssessmentBookingDto(
                booking.getBookingId(),
                booking.getQuantity(),
                booking.getTotalPrice(),
                booking.getDateCreated(),
                booking.getSampleReturnDate(),
                booking.getFeedback(),
                booking.getPaymentType(),
                booking.getPaymentStatus(),
                booking.getStatus(),
                booking.getAccount().getAccountId(),
                booking.getRequest().getRequestId(),
                bookingSamples
        );
    }

    public static AssessmentBooking toEntity(AssessmentBookingDto bookingDto, Account account, AssessmentRequest request) {
        if (bookingDto == null) {
            return null;
        }
        AssessmentBooking booking = new AssessmentBooking();
        booking.setBookingId(bookingDto.getBookingId());
        booking.setQuantity(bookingDto.getQuantity());
        booking.setTotalPrice(bookingDto.getTotalPrice());
        booking.setDateCreated(bookingDto.getDateCreated());
        booking.setSampleReturnDate(bookingDto.getSampleReturnDate());
        booking.setFeedback(bookingDto.getFeedback());
        booking.setStatus(bookingDto.getStatus());
        booking.setPaymentType(bookingDto.getPaymentType());
        booking.setPaymentStatus(bookingDto.getPaymentStatus());
        booking.setAccount(account);
        booking.setRequest(request);

        List<BookingSample> bookingSamples = bookingDto.getBookingSamples().stream()
                .map(sampleDto -> BookingSampleMapper.toEntity(sampleDto, booking))
                .collect(Collectors.toList());
        booking.setBookingSamples(bookingSamples); // Thêm dòng này

        return booking;
    }
}
