package com.luandeoliveira.hr_user.controllers;

import com.luandeoliveira.hr_user.dto.UserDTO;
import com.luandeoliveira.hr_user.entities.User;
import com.luandeoliveira.hr_user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO dto = userService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User dto = userService.findByEmail(email);
        return ResponseEntity.ok(dto);
    }
}
