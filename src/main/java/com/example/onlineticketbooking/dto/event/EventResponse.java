package com.example.onlineticketbooking.dto.event;

import com.example.onlineticketbooking.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EventResponse {

    private UUID id;
    private String name;
    private String date;
    private String time;

    private String location;
    private String availableTickets;
    private TicketDto ticket;
}
