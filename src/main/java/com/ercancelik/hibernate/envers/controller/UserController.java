package com.ercancelik.hibernate.envers.controller;

import com.ercancelik.hibernate.envers.domain.User;
import com.ercancelik.hibernate.envers.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.addUser(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User persisted = this.userService.updateUser(user);

        persisted.getUserRoles().stream().forEach(userRole -> {
            userRole.getUser().setUserRoles(null);
            userRole.getRole().setUserRoles(null);
        });
        return ResponseEntity.ok(persisted);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody User user) {
        this.userService.deleteUser(user);
        return ResponseEntity.ok("OK");
    }
}
