package com.example.onlineticketbooking.service;

import com.example.onlineticketbooking.dto.user.UserResponse;
import com.example.onlineticketbooking.error.NotFoundObjectException;
import com.example.onlineticketbooking.model.User;
import com.example.onlineticketbooking.repository.UserPagingRepository;
import com.example.onlineticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import java.util.UUID;

@Component
@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private UserPagingRepository pagingRepo;

    public User register(User user) {

        return repo.save(user);
    }

    public Page<User> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public User update(User user) {
        return repo.save(user);

    }

    public void deleteById(String userId) {
        repo.deleteById(UUID.fromString(userId));
    }
    public User findByUsername(String user_name) {

        return repo.findByUsername(user_name).orElseThrow(() ->
                new NotFoundObjectException("User Not Found for Username: " + user_name, User.class.getName(), user_name));
    }

}
