package com.nomad.k8example.gateway.event.listener;

import com.nomad.k8example.gateway.entity.User;
import com.nomad.k8example.gateway.event.RegistrationCompleteEvent;
import com.nomad.k8example.gateway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create verification link for user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
}
