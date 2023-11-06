package com.example.carsharingapp.controller;

import com.example.carsharingapp.controller.apiresponse.ApiResponse;
import com.example.carsharingapp.dto.car.CarRequestDto;
import com.example.carsharingapp.dto.car.CarResponseDto;
import com.example.carsharingapp.model.Car;
import com.example.carsharingapp.service.CarService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<Object> createCar(@Valid @RequestBody CarRequestDto carRequestDto,
                                            HttpServletResponse response) {
        CarResponseDto savedCar = carService.save(carRequestDto);
        Long carId = savedCar.getId();
        String location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carId)
                .toUriString();
        response.setHeader("Location", location);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable Long id) {
        CarResponseDto car = carService.findById(id);
        ApiResponse<CarResponseDto> response = new ApiResponse<>(car);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCars() {
        List<CarResponseDto> cars = carService.findAll();
        ApiResponse<List<CarResponseDto>> response = new ApiResponse<>(cars);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWholeCar(@PathVariable Long id,
                                                 @RequestBody CarRequestDto carRequestDto) {
        carService.updateById(id, carRequestDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id,
                                            @RequestBody CarRequestDto carRequestDto){
        carService.updateById(id, carRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
