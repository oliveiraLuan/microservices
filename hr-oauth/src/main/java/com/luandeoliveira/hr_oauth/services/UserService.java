package com.luandeoliveira.hr_oauth.services;

import com.luandeoliveira.hr_oauth.dto.UserDTO;
import com.luandeoliveira.hr_oauth.entities.User;
import com.luandeoliveira.hr_oauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(email).getBody();
        if(null == user)
            throw new UsernameNotFoundException("Usuário não encontrado");
        return user;
    }
}
