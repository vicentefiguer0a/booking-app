package com.example.bookingserver.services.user;

import com.example.bookingserver.dto.UserDto;
import com.example.bookingserver.exceptions.UserNotFoundException;
import com.example.bookingserver.models.User;
import com.example.bookingserver.repository.UserRepository;
import com.example.bookingserver.services.EncryptionService;
import com.example.bookingserver.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private EncryptionService encryptionService;
    private JwtService jwtService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EncryptionService encryptionService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    @Override
    public User registerUser(UserDto userDto) {
        // Creating user object with userDto values.
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encryptionService.encryptPassword(userDto.getPassword()));
        // Saving user object to database.
        return userRepository.save(user);
    }

    @Override
    public String loginUser(UserDto userDto) {
        // Grabbing user from database with email provided from login.
        Optional<User> userToLogin = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (userToLogin.isPresent()) {
            // If user with email provided exist in database, store in user object to compare passwords.
            User user = userToLogin.get();
            if (encryptionService.verifyPassword(userDto.getPassword(), user.getPassword())) {
                // If password from login matches password from user in database, generate JWT token.
                return jwtService.generateJwt(user);
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        // Returning list of all users in database.
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id) {
        // Returning user object from database.
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        // Grabbing user with corresponding ID from database, and storing it user object.
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User to update was not found."));
        // Updating user fields with new values.
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        // Saving user with updated fields.
        User updatedUser = userRepository.save(user);
        // Returning UserDto object.
        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUserById(long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User to delete was not found."));
        userRepository.delete(userToDelete);
    }

    // This method maps User object to UserDto object.
    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
