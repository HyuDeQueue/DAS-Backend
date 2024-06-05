package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.AssessmentBookingDto;
import com.project.DASBackend.dto.BookingSampleDto;
import com.project.DASBackend.entity.*;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.AssessmentBookingMapper;
import com.project.DASBackend.mapper.BookingSampleMapper;
import com.project.DASBackend.repository.*;
import com.project.DASBackend.service.AssessmentBookingService;
import lombok.AllArgsConstructor;
import com.project.DASBackend.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class AssessmentBookingServiceImpl implements AssessmentBookingService {

    @Autowired
    private AssessmentBookingRepository assessmentBookingRepository;
    private AccountRepository accountRepository;
    private AssessmentRequestRepository assessmentRequestRepository;
    private BookingSampleRepository bookingSampleRepository;


    @Override
    public AssessmentBookingDto createAssessmentBooking(AssessmentBookingDto assessmentBookingDto) {
        Account account = accountRepository.findById(assessmentBookingDto.getAccountId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account not found with given Id: " + assessmentBookingDto.getAccountId()));
        AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(assessmentBookingDto.getRequestId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment request not found with given Id: " + assessmentBookingDto.getRequestId()));
        AssessmentBooking assessmentBooking = AssessmentBookingMapper.toEntity(assessmentBookingDto, account, assessmentRequest);

        // Lưu các BookingSample
        List<BookingSample> bookingSamples = assessmentBookingDto.getBookingSamples().stream()
                .map(sampleDto -> {
                    BookingSample bookingSample = BookingSampleMapper.toEntity(sampleDto, assessmentBooking);
                    bookingSample.setStatus(1); // set default status to 1
                    bookingSample.setIsDiamond(1); // set default isDiamond to 1
                    return bookingSample;
                })
                .collect(Collectors.toList());
        assessmentBooking.setBookingSamples(bookingSamples);

        AssessmentBooking savedAssessmentBooking = assessmentBookingRepository.save(assessmentBooking);

        // Gán bookingId cho từng BookingSample sau khi tạo Booking
        bookingSamples.forEach(sample -> {
            sample.setBooking(savedAssessmentBooking);
            bookingSampleRepository.save(sample);
        });

        return AssessmentBookingMapper.toDto(savedAssessmentBooking);
    }






    @Override
    public AssessmentBookingDto getAssessmentBookingById(Integer bookingId) {
        AssessmentBooking assessmentBooking = assessmentBookingRepository.findById(bookingId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingId));
        return AssessmentBookingMapper.toDto(assessmentBooking);
    }

    @Override
    public List<AssessmentBookingDto> getAllAssessmentBookings() {
        List<AssessmentBooking> assessmentBookings = assessmentBookingRepository.findAll();
        return assessmentBookings.stream()
                .map(AssessmentBookingMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public AssessmentBookingDto updateAssessmentBooking(AssessmentBookingDto updatedAssessmentBookingDto, Integer bookingId) {
        AssessmentBooking assessmentBooking = assessmentBookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingId));

        if (!updatedAssessmentBookingDto.getAccountId().equals(assessmentBooking.getAccount().getAccountId())) {
            Account account = accountRepository.findById(updatedAssessmentBookingDto.getAccountId())
                    .orElseThrow(() -> new ResourceNotFoundException("Account not found with given Id: " + updatedAssessmentBookingDto.getAccountId()));
            assessmentBooking.setAccount(account);
        }

        if (!updatedAssessmentBookingDto.getRequestId().equals(assessmentBooking.getRequest().getRequestId())) {
            AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(updatedAssessmentBookingDto.getRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("Assessment request not found with given Id: " + updatedAssessmentBookingDto.getRequestId()));
            assessmentBooking.setRequest(assessmentRequest);
        }

        assessmentBooking.setStatus(updatedAssessmentBookingDto.getStatus());
        assessmentBooking.setQuantity(updatedAssessmentBookingDto.getQuantity());
        assessmentBooking.setDateCreated(updatedAssessmentBookingDto.getDateCreated());
        assessmentBooking.setFeedback(updatedAssessmentBookingDto.getFeedback());
        assessmentBooking.setSampleReturnDate(updatedAssessmentBookingDto.getSampleReturnDate());
        assessmentBooking.setTotalPrice(updatedAssessmentBookingDto.getTotalPrice());
        assessmentBooking.setPaymentType(updatedAssessmentBookingDto.getPaymentType());
        assessmentBooking.setPaymentStatus(updatedAssessmentBookingDto.getPaymentStatus());

        // Cập nhật danh sách BookingSample
        List<BookingSample> updatedBookingSamples = updatedAssessmentBookingDto.getBookingSamples().stream()
                .map(sampleDto -> BookingSampleMapper.toEntity(sampleDto, assessmentBooking))
                .collect(Collectors.toList());
        assessmentBooking.getBookingSamples().clear();
        assessmentBooking.getBookingSamples().addAll(updatedBookingSamples);

        AssessmentBooking savedAssessmentBooking = assessmentBookingRepository.save(assessmentBooking);
        return AssessmentBookingMapper.toDto(savedAssessmentBooking);
    }


    @Override
    public void deleteAssessmentBooking(Integer bookingId) {
        AssessmentBooking assessmentBooking = assessmentBookingRepository.findById(bookingId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingId));
        assessmentBookingRepository.deleteById(bookingId);
    }

    @Override
    public void changeStatus(Integer bookingId, Integer status) {
        AssessmentBooking assessmentBooking = assessmentBookingRepository.findById(bookingId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingId));
        assessmentBooking.setStatus(status);
        assessmentBookingRepository.save(assessmentBooking);
    }
}
