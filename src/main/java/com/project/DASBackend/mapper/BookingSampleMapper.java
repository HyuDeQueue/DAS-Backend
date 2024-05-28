package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.BookingSampleDto;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.BookingSample;

public class BookingSampleMapper {
    public static BookingSampleDto toDto(BookingSample sample) {
        if (sample == null) {
            return null;
        }
        return new BookingSampleDto(
                sample.getSampleId(),
                sample.getIsDiamond(),
                sample.getName(),
                sample.getSize(),
                sample.getPrice(),
                sample.getStatus(),
                sample.getBooking().getBookingId()
        );
    }

    public static BookingSample toEntity(BookingSampleDto sampleDto, AssessmentBooking booking) {
        if (sampleDto == null) {
            return null;
        }
        BookingSample sample = new BookingSample();
        sample.setSampleId(sampleDto.getSampleId());
        sample.setIsDiamond(sampleDto.getIsDiamond());
        sample.setName(sampleDto.getName());
        sample.setSize(sampleDto.getSize());
        sample.setPrice(sampleDto.getPrice());
        sample.setStatus(sampleDto.getStatus());
        sample.setBooking(booking);

        return sample;
    }

    public static void updateEntityFromDto(BookingSampleDto detailDto, BookingSample detail, AssessmentBooking booking) {
        if (detailDto == null) {
            return;
        }
        detail.setStatus(detailDto.getStatus());
        detail.setBooking(booking);
    }
}
