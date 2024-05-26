package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentBookingDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.Services;

public class AssessmentBookingMapper {
    public static AssessmentBookingDto toDto(AssessmentBooking booking) {
        if (booking == null) {
            return null;
        }
        return new AssessmentBookingDto(
                booking.getBookingId(),
                booking.getTotalPrice(),
                booking.getDateCreated(),
                booking.getDiamondReturnDate(),
                booking.getStatus(),
                booking.getPaymentType(),
                booking.getPaymentStatus(),
                booking.getFeedback(),
                booking.getAccount().getAccountId(),
                booking.getRequest().getRequestId(),
                booking.getService().getServiceId()
        );
    }

    public static AssessmentBooking toEntity(AssessmentBookingDto bookingDto, Account account, AssessmentRequest request, Services service) {
        if (bookingDto == null) {
            return null;
        }
        AssessmentBooking booking = new AssessmentBooking();
        booking.setBookingId(bookingDto.getBookingId());
        booking.setTotalPrice(bookingDto.getTotalPrice());
        booking.setDateCreated(bookingDto.getDateCreated());
        booking.setDiamondReturnDate(bookingDto.getDiamondReturnDate());
        booking.setStatus(bookingDto.getStatus());
        booking.setPaymentType(bookingDto.getPaymentType());
        booking.setPaymentStatus(bookingDto.getPaymentStatus());
        booking.setFeedback(bookingDto.getFeedback());
        booking.setAccount(account);
        booking.setRequest(request);
        booking.setService(service);
        return booking;
    }
}
