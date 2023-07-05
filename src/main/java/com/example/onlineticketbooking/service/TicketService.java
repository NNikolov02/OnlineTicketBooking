package com.example.onlineticketbooking.service;

import com.example.onlineticketbooking.error.NotFoundObjectException;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.model.User;
import com.example.onlineticketbooking.repository.TicketPagingRepository;
import com.example.onlineticketbooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class TicketService {

    @Autowired
    private TicketRepository repo;

    @Autowired
    private TicketPagingRepository pagingRepo;

    public Page<Ticket> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));


    }

    public Ticket save(Ticket ticket){
        return  repo.save(ticket);
    }
    public void deleteById(String ticketId) {
        repo.deleteById(UUID.fromString(ticketId));
    }

    public Ticket findById(String ticketsId) {
        return repo.findById(UUID.fromString(ticketsId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Ticket Not Found",Ticket.class.getName(), ticketsId);
        });
    }
}
