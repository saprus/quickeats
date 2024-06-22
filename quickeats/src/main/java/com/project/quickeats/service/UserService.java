package com.project.quickeats.service;

import com.project.quickeats.model.Grocery;
import com.project.quickeats.model.User;
import com.project.quickeats.model.UserGrocery;
import com.project.quickeats.repository.UserGroceryRepository;
import com.project.quickeats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserGroceryRepository userGroceryRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserGroceryRepository userGroceryRepository) {
        this.userRepository = userRepository;
        this.userGroceryRepository = userGroceryRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void addGroceryToUser(Long userId, Grocery grocery, Integer quantity) {
        User user = getUserById(userId);
        UserGrocery userGrocery = new UserGrocery();
        userGrocery.setUser(user);
        userGrocery.setGrocery(grocery);
        userGrocery.setQuantity(quantity);
        userGroceryRepository.save(userGrocery);
    }

    public void deleteUserById(Long id) {
        User userToBeDeleted = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(userToBeDeleted);
    }

    public User updateUserById(Long id, User userDetails) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setEmail(userDetails.getEmail());

        return userRepository.save(existingUser);
    }
}
