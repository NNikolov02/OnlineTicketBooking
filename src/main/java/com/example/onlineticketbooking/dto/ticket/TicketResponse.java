package com.example.onlineticketbooking.dto.ticket;

import com.example.onlineticketbooking.dto.EventDto;
import com.example.onlineticketbooking.dto.CustomerDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TicketResponse {
    private UUID id;

    private String quantity;

    private String totalPrize;

    private CustomerDto user;

    private EventDto event;
}
