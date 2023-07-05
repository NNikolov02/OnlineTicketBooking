package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.EventDto;
import com.example.onlineticketbooking.dto.TicketDto;
import com.example.onlineticketbooking.model.Event;
import com.example.onlineticketbooking.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapperDto {


    EventDto modelRoDto(Event event);

    Event dtoModel(Event eventDto);
}