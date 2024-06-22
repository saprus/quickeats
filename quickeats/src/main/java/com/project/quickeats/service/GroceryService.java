package com.project.quickeats.service;

import com.project.quickeats.model.Grocery;
import com.project.quickeats.model.User;
import com.project.quickeats.model.UserGrocery;
import com.project.quickeats.repository.GroceryRepository;
import com.project.quickeats.repository.UserGroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;
    private final UserGroceryRepository userGroceryRepository;
    private final UserService userService;

    @Autowired
    public GroceryService(GroceryRepository groceryRepository, UserService userService, UserGroceryRepository userGroceryRepository) {
        this.groceryRepository = groceryRepository;
        this.userService = userService;
        this.userGroceryRepository = userGroceryRepository;
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery getGroceryById(Long id) {
        return groceryRepository.findById(id).orElseThrow(() -> new RuntimeException("Grocery not found"));
    }
//    public List<Grocery> getGroceriesByUserId(Long userId) {
//        return groceryRepository.findAllByUserId(userId);
//    }
    public Grocery saveGrocery(Grocery grocery) {

        return groceryRepository.save(grocery);
//        // Save the grocery
//        Grocery savedGrocery = groceryRepository.save(grocery);
//
//        // Get the user
//        User user = userService.getUserById(userId);
//
//        // Create a new UserGrocery item
//        UserGrocery userGrocery = new UserGrocery();
//        userGrocery.setUser(user);
//        userGrocery.setGrocery(savedGrocery);
//        userGrocery.setQuantity(quantity);
//
//        // Save the UserGrocery item
//        userGroceryRepository.save(userGrocery);
//
//        return savedGrocery;
    }

    // todo: Work on this function
    public void deleteGroceryByUserIdAndGroceryId(Long userId, Long groceryId) {
}


    public Grocery updateGroceryById(Long id, Grocery groceryDetails) {
        Grocery existingGrocery = groceryRepository.findById(id).orElseThrow(() -> new RuntimeException("Grocery not found"));
        existingGrocery.setItemName(groceryDetails.getItemName());
        existingGrocery.setCategory(groceryDetails.getCategory());

        return groceryRepository.save(existingGrocery);
    }


}
