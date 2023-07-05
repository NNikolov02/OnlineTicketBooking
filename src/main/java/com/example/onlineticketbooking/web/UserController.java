package com.example.onlineticketbooking.web;


import com.example.onlineticketbooking.dto.user.UserApiPage;
import com.example.onlineticketbooking.dto.user.UserCreateRequest;
import com.example.onlineticketbooking.dto.user.UserResponse;
import com.example.onlineticketbooking.dto.user.UserUpdateRequest;
import com.example.onlineticketbooking.error.InvalidObjectException;
import com.example.onlineticketbooking.mapping.UserMapper;
import com.example.onlineticketbooking.model.User;
import com.example.onlineticketbooking.repository.UserRepository;
import com.example.onlineticketbooking.service.UserService;
import com.example.onlineticketbooking.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")

    public UserApiPage<UserResponse> getAllUsers(

            @RequestParam(required = false,defaultValue = "0") Integer currPage) {
        Page<UserResponse> userPage =
                userService.fetchAll(currPage, Page_Size).map(userMapper::responseFromModel);
        return new UserApiPage<>(userPage);
    }

    @GetMapping("/{user_name}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String user_name){

        User user = userService.findByUsername(user_name);
        return ResponseEntity.ok(userMapper.responseFromModel(user));
    }
    @PostMapping("")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserCreateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid User Create", validationErrors);
        }

        User user = userMapper.modelFromCreateRequest(userDto);

        User saveUser = userService.register(user);

        UserResponse userResponse = userMapper.responseFromModel(saveUser);

        return ResponseEntity.status(201).body(userResponse);


    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId){
       userService.deleteById(userId);
    }

    @PutMapping("/{user_name}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String user_name, @RequestBody UserUpdateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid User Update", validationErrors);
        }

        User finduser = userService.findByUsername(user_name);

        userMapper.updateModelFromDto(userDto,finduser);

        User reregistrate = userService.update(finduser);

        UserResponse userResponse = userMapper.responseFromModel(reregistrate);

        return ResponseEntity.status(200).body(userResponse);


    }
}
