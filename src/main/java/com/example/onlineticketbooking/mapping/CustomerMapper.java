package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.customer.CustomerCreateRequest;
import com.example.onlineticketbooking.dto.customer.CustomerResponse;
import com.example.onlineticketbooking.dto.customer.CustomerUpdateRequest;
import com.example.onlineticketbooking.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {TicketMapperDto.class})
public interface CustomerMapper {




    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ticket",  ignore = true)
    Customer modelFromCreateRequest(CustomerCreateRequest customerCreateDto);

    CustomerResponse responseFromModel(Customer user);
    @Mapping(target = "ticket",ignore = true)
    @Mapping(target = "username",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "role", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(CustomerUpdateRequest customerUpdateDto, @MappingTarget Customer customer);
    List<CustomerResponse> listOfModelToListOfDto(List<Customer>users);

    List<CustomerResponse> listOfModelToListOfDto(Iterable<Customer> all);


}