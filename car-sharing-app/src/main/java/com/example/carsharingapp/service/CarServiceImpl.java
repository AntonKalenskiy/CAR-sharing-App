package com.example.carsharingapp.service;

import com.example.carsharingapp.dto.car.CarRequestDto;
import com.example.carsharingapp.dto.car.CarResponseDto;
import com.example.carsharingapp.dto.mapper.CarMapper;
import com.example.carsharingapp.exception.EntityNotFoundException;
import com.example.carsharingapp.model.Car;
import com.example.carsharingapp.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarResponseDto save(CarRequestDto requestDto) {
        Car car = carMapper.toModel(requestDto);
        Car savedCar = carRepository.save(car);
        return carMapper.toDto(savedCar);
    }

    @Override
    public CarResponseDto findById(Long id) {
        return carMapper.toDto(carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Car with id: %d not found!", id))
        ));
    }

    @Override
    public List<CarResponseDto> findAll() {
        return carRepository.findAll().stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Override
    public void updateById(Long id, CarRequestDto carRequestDto) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            carMapper.updateCarFromDto(carRequestDto, car);
            carRepository.save(car);
        } else {
            throw new EntityNotFoundException(String.format(
                    "Car with id: %d not found!", id));
        }
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
