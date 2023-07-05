package com.example.onlineticketbooking.web;

import com.example.onlineticketbooking.dto.ticket.TicketApiPage;
import com.example.onlineticketbooking.dto.ticket.TicketResponse;
import com.example.onlineticketbooking.dto.user.UserApiPage;
import com.example.onlineticketbooking.dto.user.UserResponse;
import com.example.onlineticketbooking.mapping.TicketMapper;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.service.TicketService;
import com.example.onlineticketbooking.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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
    public void deleteTicketsById(@PathVariable String ticketId){ticketService.deleteById(ticketId);}


}
