package com.example.onlineticketbooking.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerDto {
    private UUID id;

    private String user_name;
    private String password;
    private String email;
    private String role;
}
