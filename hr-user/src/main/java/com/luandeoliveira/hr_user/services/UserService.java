package com.luandeoliveira.hr_user.services;

import com.luandeoliveira.hr_user.dto.UserDTO;
import com.luandeoliveira.hr_user.entities.User;
import com.luandeoliveira.hr_user.repositories.UserRepository;
import com.luandeoliveira.hr_user.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO findByEmail(String email) {
        if(!userRepository.existsByEmail(email))
            throw new UserNotFoundException("Usuário com e-mail informado não encontrado");
        User user = userRepository.findByEmail(email);
        return new UserDTO(user);
    }

    public UserDTO findById(Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("Usuário com id informado não encontrado");
        }
        Optional<User> user = userRepository.findById(id);
        return new UserDTO(user.get());
    }
}
