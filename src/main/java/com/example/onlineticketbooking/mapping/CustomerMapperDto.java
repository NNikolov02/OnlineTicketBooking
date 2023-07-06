package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.CustomerDto;
import com.example.onlineticketbooking.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapperDto {


    CustomerDto modelRoDto(Customer customer);

    Customer dtoModel(Customer customerDto);
}