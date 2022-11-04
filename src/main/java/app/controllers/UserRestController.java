package app.controllers;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.entities.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        return userService.getActiveUsers();
    }

}
