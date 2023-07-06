package com.example.onlineticketbooking.web;


import com.example.onlineticketbooking.dto.customer.CustomerApiPage;
import com.example.onlineticketbooking.dto.customer.CustomerCreateRequest;
import com.example.onlineticketbooking.dto.customer.CustomerResponse;
import com.example.onlineticketbooking.dto.customer.CustomerUpdateRequest;
import com.example.onlineticketbooking.error.InvalidObjectException;
import com.example.onlineticketbooking.mapping.CustomerMapper;
import com.example.onlineticketbooking.model.Customer;
import com.example.onlineticketbooking.service.CustomerService;
import com.example.onlineticketbooking.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")

    public CustomerApiPage<CustomerResponse> getAllUsers(

            @RequestParam(required = false,defaultValue = "0") Integer currPage) {
        Page<CustomerResponse> userPage =
                customerService.fetchAll(currPage, Page_Size).map(customerMapper::responseFromModel);
        return new CustomerApiPage<>(userPage);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getUserByUsername(@PathVariable String customerId){

        Customer user = customerService.findByUsername(customerId);
        return ResponseEntity.ok(customerMapper.responseFromModel(user));
    }
    @PostMapping("")
    public ResponseEntity<CustomerResponse> registerUser(@RequestBody CustomerCreateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid User Create", validationErrors);
        }

        Customer user = customerMapper.modelFromCreateRequest(userDto);

        Customer saveUser =customerService.register(user);

        CustomerResponse userResponse = customerMapper.responseFromModel(saveUser);

        return ResponseEntity.status(201).body(userResponse);


    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String customerId){
        customerService.deleteById(customerId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CustomerResponse> updateUser(@PathVariable String customerId, @RequestBody CustomerUpdateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid User Update", validationErrors);
        }

        Customer finduser = customerService.findByUsername(customerId);

        customerMapper.updateModelFromDto(userDto,finduser);

        Customer reregistrate = customerService.update(finduser);

        CustomerResponse userResponse = customerMapper.responseFromModel(reregistrate);

        return ResponseEntity.status(200).body(userResponse);


    }
}
