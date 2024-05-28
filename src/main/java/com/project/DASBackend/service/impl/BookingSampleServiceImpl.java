package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.BookingSampleDto;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.BookingSample;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.BookingSampleMapper;
import com.project.DASBackend.repository.AssessmentBookingRepository;
import com.project.DASBackend.repository.BookingSampleRepository;
import com.project.DASBackend.service.BookingSampleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingSampleServiceImpl implements BookingSampleService {

    @Autowired
    private BookingSampleRepository bookingSampleRepository;
    private AssessmentBookingRepository assessmentBookingRepository;

    @Override
    public BookingSampleDto createBookingDetail(BookingSampleDto bookingSampleDto) {
        AssessmentBooking booking = assessmentBookingRepository.findById(bookingSampleDto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingSampleDto.getBookingId()));

        BookingSample bookingSample = BookingSampleMapper.toEntity(bookingSampleDto, booking);
        BookingSample savedBookingSample = bookingSampleRepository.save(bookingSample);
        return BookingSampleMapper.toDto(savedBookingSample);
    }

    @Override
    public BookingSampleDto getBookingDetailById(Integer bookingDetailId) {
        BookingSample bookingSample = bookingSampleRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));
        return BookingSampleMapper.toDto(bookingSample);
    }

    @Override
    public List<BookingSampleDto> getAllBookingDetails() {
        List<BookingSample> bookingSamples = bookingSampleRepository.findAll();
        return bookingSamples.stream()
                .map(BookingSampleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingSampleDto updateBookingDetail(Integer bookingDetailId, BookingSampleDto bookingSampleDto) {
        BookingSample bookingSample = bookingSampleRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));

        AssessmentBooking booking = assessmentBookingRepository.findById(bookingSampleDto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingSampleDto.getBookingId()));

        BookingSampleMapper.updateEntityFromDto(bookingSampleDto, bookingSample, booking);
        BookingSample updatedBookingSample = bookingSampleRepository.save(bookingSample);
        return BookingSampleMapper.toDto(updatedBookingSample);
    }

    @Override
    public void deleteBookingDetail(Integer bookingDetailId) {
        BookingSample bookingSample = bookingSampleRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));
        bookingSampleRepository.delete(bookingSample);
    }
}
