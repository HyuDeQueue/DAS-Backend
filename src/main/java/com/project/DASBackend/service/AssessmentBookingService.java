package com.project.DASBackend.service;

import com.project.DASBackend.dto.AssessmentBookingDto;

import java.util.List;

public interface AssessmentBookingService {

    AssessmentBookingDto createAssessmentBooking(AssessmentBookingDto assessmentBookingDto);

    AssessmentBookingDto getAssessmentBookingById(Integer bookingId);

    List<AssessmentBookingDto> getAllAssessmentBookings();

    AssessmentBookingDto updateAssessmentBooking(AssessmentBookingDto updatedAssessmentBookingDto, Integer bookingId);

    void deleteAssessmentBooking(Integer bookingId);

    void changeStatus(Integer bookingId, Integer status);
}
