package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AssessmentRequestDto;
import com.project.DASBackend.service.AssessmentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/assessmentRequests")
public class AssessmentRequestController {

    @Autowired
    private AssessmentRequestService assessmentRequestService;

    @PostMapping
    public ResponseEntity<AssessmentRequestDto> createAssessmentRequest(AssessmentRequestDto assessmentRequestDto) {
        return new ResponseEntity<>(assessmentRequestService.createAssessmentRequest(assessmentRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AssessmentRequestDto> getAssessmentRequestById( @PathVariable("id") Integer requestId) {
        return new ResponseEntity<>(assessmentRequestService.getAssessmentRequestById(requestId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AssessmentRequestDto>> getAllAssessmentRequests() {
        return new ResponseEntity<>(assessmentRequestService.getAllAssessmentRequests(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AssessmentRequestDto> updateAssessmentRequest(@RequestBody AssessmentRequestDto assessmentRequestDto,
                                                                        @PathVariable("id") Integer requestId) {
        return new ResponseEntity<>(assessmentRequestService.updateAssessmentRequest(assessmentRequestDto, requestId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssessmentRequest(@PathVariable("id") Integer requestId) {
        assessmentRequestService.deleteAssessmentRequest(requestId);
        return new ResponseEntity<>("Assessment request deleted successfully", HttpStatus.OK);
    }


}
