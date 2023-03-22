package com.nomad.k8example.gateway.service.impl;

import com.nomad.k8example.gateway.entity.User;
import com.nomad.k8example.gateway.entity.VerificationToken;
import com.nomad.k8example.gateway.model.UserDto;
import com.nomad.k8example.gateway.repository.UserRepository;
import com.nomad.k8example.gateway.repository.VerificationTokenRepository;
import com.nomad.k8example.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;


    @Override
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken
                = new VerificationToken(token, user);

        verificationTokenRepository.save(verificationToken);
    }
}
