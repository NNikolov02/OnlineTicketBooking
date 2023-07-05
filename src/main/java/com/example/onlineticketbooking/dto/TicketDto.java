package com.example.onlineticketbooking.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TicketDto {
    private UUID id;

    private String quantity;

    private String totalPrize;
}
