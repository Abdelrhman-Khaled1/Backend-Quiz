package com.example.security.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDtoRequest {

    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String address;

}


