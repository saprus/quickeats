package com.project.quickeats.controller;

import com.project.quickeats.dto.UserGroceryDTO;
import com.project.quickeats.model.Grocery;
import com.project.quickeats.model.User;
import com.project.quickeats.service.GroceryService;
import com.project.quickeats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final GroceryService groceryService;

    @Autowired
    public UserController(UserService userService, GroceryService groceryService) {
        this.userService = userService;
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/{userId}/groceries")
    public ResponseEntity<?> addGroceryToUser(@PathVariable Long userId, @RequestBody UserGroceryDTO userGroceryDTO) {
        Grocery grocery = groceryService.getGroceryById(userGroceryDTO.getGroceryId());
        userService.addGroceryToUser(userId, grocery, userGroceryDTO.getQuantity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUserById(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
