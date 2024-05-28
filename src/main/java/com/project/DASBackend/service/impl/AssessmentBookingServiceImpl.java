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
    private ServiceRepository serviceRepository;
    private AssessmentRequestRepository assessmentRequestRepository;
    private BookingSampleRepository bookingSampleRepository;

    @Override
    public AssessmentBookingDto createAssessmentBooking(AssessmentBookingDto assessmentBookingDto) {
        Account account = accountRepository.findById(assessmentBookingDto.getAccountId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account not found with given Id: " + assessmentBookingDto.getAccountId()));
//        Services service = serviceRepository.findById(assessmentBookingDto.getServiceId())
//                .orElseThrow(
//                        () -> new ResourceNotFoundException("Service not found with given Id: " + assessmentBookingDto.getServiceId()));
        AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(assessmentBookingDto.getRequestId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment request not found with given Id: " + assessmentBookingDto.getRequestId()));
//        AssessmentBooking assessmentBooking = AssessmentBookingMapper.toEntity(assessmentBookingDto, account, assessmentRequest, service);
        AssessmentBooking assessmentBooking = AssessmentBookingMapper.toEntity(assessmentBookingDto, account, assessmentRequest);
        AssessmentBooking savedAssessmentBooking = assessmentBookingRepository.save(assessmentBooking);
        //tao booking detail chua assessmentBooking
        //i=0 to n kc
        //tạo booking detail chứa savedAssessmentBookingId

        for(int i = 0; i < savedAssessmentBooking.getNumberOfDiamonds(); i++){
            BookingSampleDto newBookingSampleDto = new BookingSampleDto();
            newBookingSampleDto.setStatus(1);
            BookingSample newBookingSample = BookingSampleMapper.toEntity(newBookingSampleDto, savedAssessmentBooking);
            bookingSampleRepository.save(newBookingSample);
        }



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
        return assessmentBookings.stream().map(assessmentBooking -> AssessmentBookingMapper.toDto(assessmentBooking))
                .collect(Collectors.toList());
        //lấy all bookingDetail trùng ID
    }

    @Override
    public AssessmentBookingDto updateAssessmentBooking(AssessmentBookingDto updatedAssessmentBookingDto, Integer bookingId) {
        AssessmentBooking assessmentBooking = assessmentBookingRepository.findById(bookingId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingId));
        if(!updatedAssessmentBookingDto.getAccountId().equals(assessmentBooking.getAccount().getAccountId())) {
            Account account = accountRepository.findById(updatedAssessmentBookingDto.getAccountId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Account not found with given Id: " + updatedAssessmentBookingDto.getAccountId()));
            assessmentBooking.setAccount(account);
        }
//        if(!updatedAssessmentBookingDto.getServiceId().equals(assessmentBooking.getService().getServiceId())) {
//            Services service = serviceRepository.findById(updatedAssessmentBookingDto.getServiceId())
//                    .orElseThrow(
//                            () -> new ResourceNotFoundException("Service not found with given Id: " + updatedAssessmentBookingDto.getServiceId()));
//            assessmentBooking.setService(service);
//        }
        if(!updatedAssessmentBookingDto.getRequestId().equals(assessmentBooking.getRequest().getRequestId())) {
            AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(updatedAssessmentBookingDto.getRequestId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Assessment request not found with given Id: " + updatedAssessmentBookingDto.getRequestId()));
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
}
