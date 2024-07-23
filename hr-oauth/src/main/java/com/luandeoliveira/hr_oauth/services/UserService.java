package com.luandeoliveira.hr_oauth.services;

import com.luandeoliveira.hr_oauth.dto.UserDTO;
import com.luandeoliveira.hr_oauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserFeignClient userFeignClient;

    public UserDTO findByEmail(String email){
        UserDTO dto = userFeignClient.findByEmail(email).getBody();
        if(null == dto)
            throw new IllegalArgumentException();
        return dto;
    }
}
