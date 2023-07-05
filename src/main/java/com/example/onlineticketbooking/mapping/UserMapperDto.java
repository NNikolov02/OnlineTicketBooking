package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.TicketDto;
import com.example.onlineticketbooking.dto.UserDto;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapperDto {


    UserDto modelRoDto(User user);

    User dtoModel(User userDto);
}