package com.example.carsharingapp.dto.car;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarRequestDto {
    @NotBlank
    @NotNull
    private String model;
    @NotBlank
    @NotNull
    private String brand;
    @NotBlank
    @NotNull
    private String type;
    @NotNull
    @Min(value = 0)
    private int inventory;
    @NotNull
    @Min(value = 0)
    private BigDecimal dailyFee;
}
