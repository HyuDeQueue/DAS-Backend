package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AssessmentBookingDto;
import com.project.DASBackend.service.AssessmentBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessmentBookings")
public class AssessmentBookingController {

    @Autowired
    private AssessmentBookingService assessmentBookingService;

    @PostMapping
    public ResponseEntity<String> createAssessmentBooking(AssessmentBookingDto assessmentBookingDto) {
        assessmentBookingService.createAssessmentBooking(assessmentBookingDto);
        return ResponseEntity.ok("Assessment booking created successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<AssessmentBookingDto> getAssessmentBookingById(@PathVariable("id") Integer bookingId) {
        AssessmentBookingDto assessmentBookingDto = assessmentBookingService.getAssessmentBookingById(bookingId);
        return ResponseEntity.ok(assessmentBookingDto);
    }

    @GetMapping
    public ResponseEntity<List<AssessmentBookingDto>> getAllAssessmentBookings() {
        List<AssessmentBookingDto> assessmentBookingDtos = assessmentBookingService.getAllAssessmentBookings();
        return ResponseEntity.ok(assessmentBookingDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateAssessmentBooking(@RequestBody AssessmentBookingDto updatedAssessmentBookingDto,
                                                            @PathVariable("id") Integer bookingId) {
        assessmentBookingService.updateAssessmentBooking(updatedAssessmentBookingDto, bookingId);
        return ResponseEntity.ok("Assessment booking updated successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssessmentBooking(@PathVariable("id") Integer bookingId) {
        assessmentBookingService.deleteAssessmentBooking(bookingId);
        return ResponseEntity.ok("Assessment booking deleted successfully");
    }
}
