package com.example.onlineticketbooking.dto.event;

import com.example.onlineticketbooking.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventUpdateRequest {

    private String name;
    private String date;
    private String time;

    private String location;
    private String availableTickets;
    private TicketDto ticket;
}
