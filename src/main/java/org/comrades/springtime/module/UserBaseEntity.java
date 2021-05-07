package org.comrades.springtime.module;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class UserBaseEntity {

    public UserBaseEntity() {}

    public UserBaseEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Column(name = "login")
    @NonNull
    private String login;

    @Column(name = "password")
    @NonNull
    private String password;
}
