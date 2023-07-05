package com.example.onlineticketbooking.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EventDto {
    private UUID id;

    private String name;
    private String date;
    private String time;

    private String location;
    private String availableTickets;
}
