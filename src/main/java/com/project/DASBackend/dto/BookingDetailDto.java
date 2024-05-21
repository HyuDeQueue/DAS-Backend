package com.project.DASBackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookingDetailDto {
    private Integer detailId;
    private Integer status;
    private Integer bookingId;
}
