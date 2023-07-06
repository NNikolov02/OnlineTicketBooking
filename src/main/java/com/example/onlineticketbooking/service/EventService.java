package com.example.onlineticketbooking.service;

import com.example.onlineticketbooking.dto.event.EventResponse;
import com.example.onlineticketbooking.error.NotFoundObjectException;
import com.example.onlineticketbooking.model.Event;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.repository.EventPagingRepository;
import com.example.onlineticketbooking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    @Autowired
    private EventPagingRepository pagingRepo;

    public Page<Event> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));


    }

    public Event create(Event event){
        return  repo.save(event);
    }
    public void delete(String eventId) {
        repo.deleteById(UUID.fromString(eventId));
    }

    public Event findById(String eventId) {
        return repo.findById(UUID.fromString(eventId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Event Not Found",Ticket.class.getName(), eventId);
        });
    }

}
