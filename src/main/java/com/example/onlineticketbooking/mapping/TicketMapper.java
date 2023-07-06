package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.ticket.TicketCreateRequest;
import com.example.onlineticketbooking.dto.ticket.TicketResponse;
import com.example.onlineticketbooking.dto.ticket.TicketUpdateRequest;
import com.example.onlineticketbooking.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {EventMapperDto.class, CustomerMapperDto.class})
public interface TicketMapper {




    @Mapping(target = "id", ignore = true)
    @Mapping(target = "event",  ignore = true)
    @Mapping(target = "customer", ignore = true)
    Ticket modelFromCreateRequest(TicketCreateRequest ticketCreateDto);

  TicketResponse responseFromModel(Ticket ticket);
    @Mapping(target = "event",ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "quantity",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "totalPrize", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(TicketUpdateRequest ticketUpdateDto, @MappingTarget Ticket ticket);
    List<TicketResponse> listOfModelToListOfDto(List<Ticket>tickets);

    List<TicketResponse> listOfModelToListOfDto(Iterable<Ticket> all);


}
