package com.example.carsharingapp.service;

import com.example.carsharingapp.dto.car.CarRequestDto;
import com.example.carsharingapp.dto.car.CarResponseDto;
import java.util.List;

public interface CarService {
    CarResponseDto save(CarRequestDto requestDto);

    CarResponseDto findById(Long id);

    List<CarResponseDto> findAll();

    void updateById(Long id, CarRequestDto carRequestDto);

    void deleteById(Long id);
}
