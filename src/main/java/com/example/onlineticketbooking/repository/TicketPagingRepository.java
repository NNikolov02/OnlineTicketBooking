package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketPagingRepository extends PagingAndSortingRepository<Ticket, UUID> {

}