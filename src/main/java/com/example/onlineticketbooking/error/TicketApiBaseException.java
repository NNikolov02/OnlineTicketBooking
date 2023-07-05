package com.example.onlineticketbooking.error;

import java.util.UUID;

public class TicketApiBaseException extends RuntimeException {
    private final UUID errorid;
    public TicketApiBaseException(String massage){
        super(massage);
        this.errorid = UUID.randomUUID();


    }

    public UUID getErrorId() {
        return errorid;
    }
}