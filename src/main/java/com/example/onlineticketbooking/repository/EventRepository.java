package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Event;
import com.example.onlineticketbooking.model.Ticket;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends CrudRepository<Event, UUID> {

}
