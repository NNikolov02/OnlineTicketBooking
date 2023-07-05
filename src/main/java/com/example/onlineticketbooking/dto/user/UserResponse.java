package com.example.onlineticketbooking.dto.user;

import com.example.onlineticketbooking.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;

    private String user_name;
    private String password;
    private String email;
    private String role;
    private TicketDto ticket;
}
