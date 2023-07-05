package com.example.onlineticketbooking.mapping;

import com.example.onlineticketbooking.dto.ticket.TicketCreateRequest;
import com.example.onlineticketbooking.dto.ticket.TicketResponse;
import com.example.onlineticketbooking.dto.ticket.TicketUpdateRequest;
import com.example.onlineticketbooking.dto.user.UserCreateRequest;
import com.example.onlineticketbooking.dto.user.UserResponse;
import com.example.onlineticketbooking.dto.user.UserUpdateRequest;
import com.example.onlineticketbooking.model.Ticket;
import com.example.onlineticketbooking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {TicketMapperDto.class})
public interface UserMapper {




    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ticket",  ignore = true)
    User modelFromCreateRequest(UserCreateRequest userCreateDto);

    UserResponse responseFromModel(User user);
    @Mapping(target = "ticket",ignore = true)
    @Mapping(target = "user_name",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "role", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(UserUpdateRequest ticketUpdateDto, @MappingTarget User user);
    List<UserResponse> listOfModelToListOfDto(List<User>users);

    List<UserResponse> listOfModelToListOfDto(Iterable<User> all);


}