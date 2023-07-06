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
public class Customer {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private UUID id;

    @Column(name = "username", unique = true)
    private String username;
    private String password;
    private String email;
    private String role;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private Ticket ticket;
}
