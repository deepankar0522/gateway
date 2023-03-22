package com.nomad.k8example.gateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonFormat
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String matchingPassword;
}
