package com.example.onlineticketbooking.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private UUID id;

    private String name;
    private String date;
    private String time;

    private String location;
    private String availableTickets;

    @OneToOne(mappedBy = "event", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("event")
    private Ticket ticket;
}
