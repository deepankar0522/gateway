package com.nomad.k8example.gateway.service;

import com.nomad.k8example.gateway.entity.User;
import com.nomad.k8example.gateway.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserDto userDto);

    void saveVerificationTokenForUser(String token, User user);
}
