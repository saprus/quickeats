package com.project.financetracker.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public void userLogin() {

        // todo: Add how to capture the data passed in from the UI into the fields
    }

    @PostMapping(path = "/register")
    public void userRegister() {

        // todo: Add how to capture the data passed in from the UI into the fields
    }

    @GetMapping(path = "/profile")
    public void getUser() {

        // todo: Add how to capture the data passed in from the UI into the fields
    }

    @PutMapping(path = "/profile")
    public void updateUser() {

        // todo: Add how to capture the data passed in from the UI into the fields
    }

}
