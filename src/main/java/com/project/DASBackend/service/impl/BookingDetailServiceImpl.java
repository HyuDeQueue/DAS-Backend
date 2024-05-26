package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.BookingDetailDto;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.BookingDetail;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.BookingDetailMapper;
import com.project.DASBackend.repository.AssessmentBookingRepository;
import com.project.DASBackend.repository.BookingDetailRepository;
import com.project.DASBackend.service.BookingDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingDetailServiceImpl implements BookingDetailService {

    private BookingDetailRepository bookingDetailRepository;
    private AssessmentBookingRepository assessmentBookingRepository;

    @Override
    public BookingDetailDto createBookingDetail(BookingDetailDto bookingDetailDto) {
        AssessmentBooking booking = assessmentBookingRepository.findById(bookingDetailDto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingDetailDto.getBookingId()));

        BookingDetail bookingDetail = BookingDetailMapper.toEntity(bookingDetailDto, booking);
        BookingDetail savedBookingDetail = bookingDetailRepository.save(bookingDetail);
        return BookingDetailMapper.toDto(savedBookingDetail);
    }

    @Override
    public BookingDetailDto getBookingDetailById(Integer bookingDetailId) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));
        return BookingDetailMapper.toDto(bookingDetail);
    }

    @Override
    public List<BookingDetailDto> getAllBookingDetails() {
        List<BookingDetail> bookingDetails = bookingDetailRepository.findAll();
        return bookingDetails.stream()
                .map(BookingDetailMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDetailDto updateBookingDetail(Integer bookingDetailId, BookingDetailDto bookingDetailDto) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));

        AssessmentBooking booking = assessmentBookingRepository.findById(bookingDetailDto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment booking not found with given Id: " + bookingDetailDto.getBookingId()));

        BookingDetailMapper.updateEntityFromDto(bookingDetailDto, bookingDetail, booking);
        BookingDetail updatedBookingDetail = bookingDetailRepository.save(bookingDetail);
        return BookingDetailMapper.toDto(updatedBookingDetail);
    }

    @Override
    public void deleteBookingDetail(Integer bookingDetailId) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with given Id: " + bookingDetailId));
        bookingDetailRepository.delete(bookingDetail);
    }
}
