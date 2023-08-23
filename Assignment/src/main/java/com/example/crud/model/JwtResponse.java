package com.example.crud.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder

public class JwtResponse {

    private String jwtToken;
    private String username;
}
