package org.comrades.springtime.module.requested;

import lombok.Data;

@Data
public class TestAuthenticationRequestDto {
    private String login; //email
    private String password; //password (один раз)
    private String group; // group
    private String firstname; //firstname
    private String secondname; //secondname
    private String course; // course
    private String role; //role
}
