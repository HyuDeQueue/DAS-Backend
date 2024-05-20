package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentBookingDto;
import com.project.DASBackend.entity.AssessmentBooking;

public class AssessmentBookingMapper {
    public static AssessmentBookingDto toDto(AssessmentBooking booking) {
        if (booking == null) {
            return null;
        }

        AssessmentBookingDto dto = new AssessmentBookingDto();
        dto.setBookingId(booking.getBookingId());
        dto.setCreatedDate(booking.getCreatedDate());
        dto.setDateModified(booking.getDateModified());
        dto.setDiamondReturnDate(booking.getDiamondReturnDate());
        dto.setPaymentStatus(booking.getPaymentStatus());
        dto.setPaymentType(booking.getPaymentType());
        dto.setStatus(booking.getStatus());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setAccountId(booking.getAccount().getAccountId());
        dto.setRequestId(booking.getAssessmentRequest().getRequestId());
        dto.setServiceId(booking.getService().getServiceId());

        return dto;
    }

    public static AssessmentBooking toEntity(AssessmentBookingDto dto) {
        if (dto == null) {
            return null;
        }

        AssessmentBooking booking = new AssessmentBooking();
        booking.setBookingId(dto.getBookingId());
        booking.setCreatedDate(dto.getCreatedDate());
        booking.setDateModified(dto.getDateModified());
        booking.setDiamondReturnDate(dto.getDiamondReturnDate());
        booking.setPaymentStatus(dto.getPaymentStatus());
        booking.setPaymentType(dto.getPaymentType());
        booking.setStatus(dto.getStatus());
        booking.setTotalPrice(dto.getTotalPrice());

        // You need to set the account, request, and service entities separately.
        // Assuming you have a method to fetch these entities:
        // booking.setAccount(accountService.findById(dto.getAccountId()));
        // booking.setRequest(requestService.findById(dto.getRequestId()));
        // booking.setService(serviceService.findById(dto.getServiceId()));

        return booking;
    }
}
