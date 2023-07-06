package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.event.EventCreateRequest;
import com.example.onlineticketbooking.dto.event.EventResponse;
import com.example.onlineticketbooking.dto.event.EventUpdateRequest;
import com.example.onlineticketbooking.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {TicketMapperDto.class})
public interface EventMapper {




    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ticket",  ignore = true)
    Event modelFromCreateRequest(EventCreateRequest eventCreateDto);

   EventResponse responseFromModel(Event event);
    @Mapping(target = "ticket",ignore = true)
    @Mapping(target = "name",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "date", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "time", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "availableTickets", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "location", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(EventUpdateRequest eventUpdateDto, @MappingTarget Event event);
    List<EventResponse> listOfModelToListOfDto(List<Event>events);

    List<EventResponse> listOfModelToListOfDto(Iterable<Event> all);


}