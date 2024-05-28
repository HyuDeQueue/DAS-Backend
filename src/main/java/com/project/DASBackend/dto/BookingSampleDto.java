package com.project.DASBackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookingSampleDto {
    private Integer sampleId;
    private Integer isDiamond;
    private String name;
    private Float size;
    private Integer price;
    private Integer status;
    private Integer bookingId;
}
