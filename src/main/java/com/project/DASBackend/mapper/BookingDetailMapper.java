package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.BookingDetailDto;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.BookingDetail;

public class BookingDetailMapper {
    public static BookingDetailDto toDto(BookingDetail detail) {
        if (detail == null) {
            return null;
        }
        return new BookingDetailDto(
                detail.getDetailId(),
                detail.getStatus(),
                detail.getBooking().getBookingId()
        );
    }

    public static BookingDetail toEntity(BookingDetailDto detailDto, AssessmentBooking booking) {
        if (detailDto == null) {
            return null;
        }
        BookingDetail detail = new BookingDetail();
        detail.setDetailId(detailDto.getDetailId());
        detail.setStatus(detailDto.getStatus());
        detail.setBooking(booking);
        return detail;
    }

    public static void updateEntityFromDto(BookingDetailDto detailDto, BookingDetail detail, AssessmentBooking booking) {
        if (detailDto == null) {
            return;
        }
        detail.setStatus(detailDto.getStatus());
        detail.setBooking(booking);
    }
}
