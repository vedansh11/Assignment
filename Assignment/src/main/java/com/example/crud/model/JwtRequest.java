package com.example.crud.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class JwtRequest {

    private String email;
    private String password;
}
