package com.project.DASBackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookingSampleDto {

    @NotNull(message = "Sample ID cannot be null")
    private Integer sampleId;

    @NotNull(message = "isDiamond cannot be null")
    private Integer isDiamond;

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Size cannot be null")
    @Min(value = 0, message = "Size must be greater than or equal to 0")
    private Float size;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Integer price;

    @NotNull(message = "Status cannot be null")
    private Integer status;

    @NotNull(message = "Booking ID cannot be null")
    private Integer bookingId;
}
