package com.project.quickeats.service;

import com.project.quickeats.model.Grocery;
import com.project.quickeats.model.User;
import com.project.quickeats.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;
    private final UserService userService;

    @Autowired
    public GroceryService(GroceryRepository groceryRepository, UserService userService) {
        this.groceryRepository = groceryRepository;
        this.userService = userService;
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery getGroceryById(Long id) {
        return groceryRepository.findById(id).orElseThrow(() -> new RuntimeException("Grocery not found"));
    }
    public List<Grocery> getGroceriesByUserId(Long userId) {
        return groceryRepository.findAllByUserId(userId);
    }
    public Grocery saveGrocery(Grocery grocery) {
        // Here we are getting the appropriate User by grocery's "userId"
        // and adding it to that particular User's grocery
        User groceryUser = userService.getUserById(grocery.getUser().getId());
        grocery.setUser(groceryUser);
        return groceryRepository.save(grocery);
    }

    // todo: Work on this function
    public void deleteGroceryByUserIdAndGroceryId(Long userId, Long groceryId) {

    User user = userService.getUserById(userId);

    Grocery grocery = groceryRepository.findById(groceryId)
        .orElseThrow(() -> new RuntimeException("Grocery not found"));

    // Check if the User is the correct one
    if (!grocery.getUser().getId().equals(user.getId())) {
        throw new RuntimeException("User ID does not match with the grocery's user ID");
    }

    // If the User is correct, delete the grocery
    groceryRepository.delete(grocery);

    // Update the grocery count for the user
    //    List<Grocery> userGroceries = groceryRepository.findAllByUserId(userId);
    //    user.setGroceryCount(userGroceries.size());

    // Save the updated user
    userService.saveUser(user);
}


    public Grocery updateGroceryById(Long id, Grocery groceryDetails) {
        Grocery existingGrocery = groceryRepository.findById(id).orElseThrow(() -> new RuntimeException("Grocery not found"));
        existingGrocery.setItemName(groceryDetails.getItemName());
        existingGrocery.setCategory(groceryDetails.getCategory());
        existingGrocery.setQuantity(groceryDetails.getQuantity());

        return groceryRepository.save(existingGrocery);
    }


}
