package com.example.onlineticketbooking.service;

import com.example.onlineticketbooking.error.NotFoundObjectException;
import com.example.onlineticketbooking.model.Customer;
import com.example.onlineticketbooking.repository.CustomerPagingRepository;
import com.example.onlineticketbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import java.util.UUID;

@Component
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    @Autowired
    private CustomerPagingRepository pagingRepo;

    public Customer register(Customer customer) {

        return repo.save(customer);
    }

    public Page<Customer> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Customer update(Customer customer) {
        return repo.save(customer);

    }

    public void deleteById(String customerId) {
        repo.deleteById(UUID.fromString( customerId));
    }
    public Customer findByUsername(String  customerId) {

        return repo.findById(UUID.fromString( customerId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Customer Not Found", Customer.class.getName(),  customerId);
        });
    }

}
