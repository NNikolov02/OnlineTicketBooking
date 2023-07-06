package com.example.onlineticketbooking.repository;

import com.example.onlineticketbooking.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CustomerPagingRepository extends PagingAndSortingRepository<Customer, UUID> {

}