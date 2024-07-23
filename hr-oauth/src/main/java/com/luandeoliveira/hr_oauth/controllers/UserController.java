package com.luandeoliveira.hr_oauth.controllers;

import com.luandeoliveira.hr_oauth.dto.UserDTO;
import com.luandeoliveira.hr_oauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email){
        try{
            UserDTO dto = userService.findByEmail(email);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
}
