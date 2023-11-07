package com.example.carsharingapp.dto.mapper;

import com.example.carsharingapp.config.MapperConfig;
import com.example.carsharingapp.dto.car.CarRequestDto;
import com.example.carsharingapp.dto.car.CarResponseDto;
import com.example.carsharingapp.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = MapperConfig.class)
public interface CarMapper {

    @Mapping(target = "type", qualifiedByName = "carTypeToString")
    CarResponseDto toDto(Car car);

    @Mapping(target = "type", qualifiedByName = "stringToCarType")
    Car toModel(CarRequestDto carRequestDto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "model", source = "model",
                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "brand", source = "brand",
                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "type", source = "type",
                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "inventory", source = "inventory",
                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "dailyFee", source = "dailyFee",
                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    })
    void updateCarFromDto(CarRequestDto carRequestDto, @MappingTarget Car car);

    //custom mappings
    @Named("stringToCarType")
    default Car.CarType stringToCarType(String carType) {
        return Car.CarType.valueOf(carType);
    }

    @Named("carTypeToString")
    default String carTypeToString(Car.CarType carType) {
        return carType.name();
    }
}
