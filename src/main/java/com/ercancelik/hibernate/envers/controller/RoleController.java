package com.ercancelik.hibernate.envers.controller;

import com.ercancelik.hibernate.envers.domain.Role;
import com.ercancelik.hibernate.envers.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/roles")
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping
    public ResponseEntity<Role> add(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(role));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Role role) {
        roleService.deleteRole(role);
        return ResponseEntity.ok("OK");
    }
}

