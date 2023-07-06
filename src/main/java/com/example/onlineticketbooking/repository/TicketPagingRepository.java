package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketPagingRepository extends PagingAndSortingRepository<Ticket, UUID> {

}