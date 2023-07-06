package com.example.onlineticketbooking.web;


import com.example.onlineticketbooking.dto.event.EventApiPage;
import com.example.onlineticketbooking.dto.event.EventCreateRequest;
import com.example.onlineticketbooking.dto.event.EventResponse;
import com.example.onlineticketbooking.dto.ticket.TicketApiPage;
import com.example.onlineticketbooking.dto.ticket.TicketResponse;
import com.example.onlineticketbooking.error.InvalidObjectException;
import com.example.onlineticketbooking.mapping.EventMapper;
import com.example.onlineticketbooking.model.Event;
import com.example.onlineticketbooking.repository.EventPagingRepository;
import com.example.onlineticketbooking.repository.EventRepository;
import com.example.onlineticketbooking.service.EventService;
import com.example.onlineticketbooking.service.TicketService;
import com.example.onlineticketbooking.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMapper eventMapper;

    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")

    public EventApiPage<EventResponse> getAllEvents(

            @RequestParam(required = false,defaultValue = "0") Integer currPage) {
        Page<EventResponse> eventPage =
                eventService.fetchAll(currPage, Page_Size).map(eventMapper::responseFromModel);
        return new EventApiPage<>(eventPage);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable String eventId){

        Event event = eventService.findById(eventId);

        return ResponseEntity.ok(eventMapper.responseFromModel(event));
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable String eventId){
        eventService.delete(eventId);
    }

    @PostMapping("")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventCreateRequest eventDto){

        Map<String, String> validationErrors = validator.validate(eventDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Event Create", validationErrors);
        }
        Event event = eventMapper.modelFromCreateRequest(eventDto);

        Event createEvent = eventService.create(event);

        EventResponse eventResponse = eventMapper.responseFromModel(createEvent);

        return ResponseEntity.status(201).body(eventResponse);

    }

}
