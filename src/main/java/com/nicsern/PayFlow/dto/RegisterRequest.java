package com.nicsern.PayFlow.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegisterRequest {
    
    private String username;
    private String email;
    private String password;
    private String password2;
}
