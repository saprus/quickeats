package com.project.quickeats.controller;

import com.project.quickeats.model.Grocery;
import com.project.quickeats.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
public class GroceryController {

    private final GroceryService groceryService;

    @Autowired
    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @GetMapping("/{userId}")
    public List<Grocery> getGroceriesByUserId(@PathVariable Long userId) {
        return groceryService.getGroceriesByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grocery> getGroceryById(@PathVariable Long id) {
        Grocery groceryById = groceryService.getGroceryById(id);
        return ResponseEntity.ok(groceryById);
    }

    @PostMapping
    public ResponseEntity<Grocery> saveGrocery(@RequestBody Grocery grocery) {
        Grocery newGrocery = groceryService.saveGrocery(grocery);
        return ResponseEntity.ok(newGrocery);
    }

    // todo: implement updateGroceryByUserId()

    // todo: implement deleteGroceryByUserIdAndGroceryId()


}
