package com.example.onlineticketbooking.web;

import com.example.onlineticketbooking.dto.ticket.TicketApiPage;
import com.example.onlineticketbooking.dto.ticket.TicketCreateRequest;
import com.example.onlineticketbooking.dto.ticket.TicketResponse;
import com.example.onlineticketbooking.dto.ticket.TicketUpdateRequest;
import com.example.onlineticketbooking.error.InvalidObjectException;
import com.example.onlineticketbooking.mapping.TicketMapper;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.service.TicketService;
import com.example.onlineticketbooking.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")

    public TicketApiPage<TicketResponse> getAllTickets(

            @RequestParam(required = false,defaultValue = "0") Integer currPage) {
        Page<TicketResponse> ticketPage =
                ticketService.fetchAll(currPage, Page_Size).map(ticketMapper::responseFromModel);
        return new TicketApiPage<>(ticketPage);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getTicketsById(@PathVariable String ticketId){
        Ticket ticket = ticketService.findById(ticketId);


        return ResponseEntity.ok(ticketMapper.responseFromModel(ticket));
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicketsById(@PathVariable String ticketId){ticketService.cancelTicket(ticketId);}

    @PostMapping("")
    public ResponseEntity<TicketResponse>createTicket(@RequestBody TicketCreateRequest ticketDto){
        Map<String, String> validationErrors = validator.validate(ticketDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Ticket Create", validationErrors);
        }

        Ticket ticket = ticketMapper.modelFromCreateRequest(ticketDto);

        Ticket saveTicket = ticketService.bookTicket(ticket);

        TicketResponse ticketResponse = ticketMapper.responseFromModel(saveTicket);

        return  ResponseEntity.status(201).body(ticketResponse);

    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponse>updateTicket(@PathVariable String ticketId, @RequestBody TicketUpdateRequest ticketDto){
        Map<String, String> validationErrors = validator.validate(ticketDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Ticket Update", validationErrors);
        }

        Ticket findTicket = ticketService.findById(ticketId);

        ticketMapper.updateModelFromDto(ticketDto,findTicket);

        Ticket saveTicket = ticketService.bookTicket(findTicket);

        TicketResponse ticketResponse = ticketMapper.responseFromModel(saveTicket);

        return ResponseEntity.status(200).body(ticketResponse);
    }


}
