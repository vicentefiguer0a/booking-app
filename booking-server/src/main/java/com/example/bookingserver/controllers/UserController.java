package com.example.bookingserver.controllers;

import com.example.bookingserver.dto.UserDto;
import com.example.bookingserver.exceptions.UserNotFoundException;
import com.example.bookingserver.models.LoginResponse;
import com.example.bookingserver.models.User;
import com.example.bookingserver.services.EncryptionService;
import com.example.bookingserver.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:5173")
public class UserController {

    private UserService userService;
    private EncryptionService encryptionService;

    @Autowired
    private UserController(UserService userService, EncryptionService encryptionService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        try {
            userService.registerUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("User with that email already exists.", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody UserDto userDto) {
        String jwt = userService.loginUser(userDto);
        LoginResponse loginResponse = new LoginResponse();
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            Optional<User> userToLogin = Optional.ofNullable(userService.getUserByEmail(userDto.getEmail()));
            if (userToLogin.isPresent()) {
                // If user with email provided exist in database, store in user object to compare passwords.
                User user = userToLogin.get();
                if (encryptionService.verifyPassword(userDto.getPassword(), user.getPassword())) {
                    loginResponse.setUserId(user.getId());
                    loginResponse.setFirstName(user.getFirstName());
                    loginResponse.setLastName(user.getLastName());
                    loginResponse.setEmail(user.getEmail());
                    loginResponse.setJwt(jwt);
                }
            }
            return ResponseEntity.ok(loginResponse);
        }
    }

    @GetMapping("/user")
    public User getLoggedInUserProfile(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUserDetails(@PathVariable long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with the ID " + id + " was not found."));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/user/{id}/edit")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable long id) {
        UserDto response = userService.updateUser(userDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User has been successfully deleted.", HttpStatus.OK);
    }
}
