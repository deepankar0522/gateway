package com.nomad.k8example.gateway.controller;

import com.nomad.k8example.gateway.entity.User;
import com.nomad.k8example.gateway.event.RegistrationCompleteEvent;
import com.nomad.k8example.gateway.model.UserDto;
import com.nomad.k8example.gateway.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping
    public String registerUser(@RequestBody UserDto userDto, final HttpServletRequest request) {
        User user = userService.registerUser(userDto);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "registered " + user.getUsername();
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
