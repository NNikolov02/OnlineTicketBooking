package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.TicketDto;
import com.example.onlineticketbooking.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapperDto {


    TicketDto modelRoDto(Ticket ticket);

    Ticket dtoModel(Ticket ticketDto);
}