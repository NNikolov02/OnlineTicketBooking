package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Event;
import com.example.onlineticketbooking.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface EventPagingRepository extends PagingAndSortingRepository<Event, UUID> {

}