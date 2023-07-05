package com.example.onlineticketbooking.dto.ticket;

import com.example.onlineticketbooking.dto.EventDto;
import com.example.onlineticketbooking.dto.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TicketCreateRequest {

    private String quantity;

    private String totalPrize;

    private UserDto user;

    private EventDto event;
}
