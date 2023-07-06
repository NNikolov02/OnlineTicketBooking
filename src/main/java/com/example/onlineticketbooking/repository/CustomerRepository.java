package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,UUID> {


}
