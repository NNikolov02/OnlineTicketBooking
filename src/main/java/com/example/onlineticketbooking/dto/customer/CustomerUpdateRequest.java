package com.example.onlineticketbooking.dto.customer;

import com.example.onlineticketbooking.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerUpdateRequest {

    private String username;
    private String password;
    private String email;
    private String role;
    private TicketDto ticket;
}
