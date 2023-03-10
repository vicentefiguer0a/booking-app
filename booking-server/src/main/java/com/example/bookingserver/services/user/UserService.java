package com.example.bookingserver.services.user;

import com.example.bookingserver.dto.UserDto;
import com.example.bookingserver.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(UserDto userDto);
    String loginUser(UserDto userDto);
    List<User> getAllUsers();
    Optional<User> getUserById(long id);
    User getUserByEmail(String email);
    UserDto updateUser(UserDto userDto, long id);
    void deleteUserById(long id);
}
