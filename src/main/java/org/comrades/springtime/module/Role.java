package org.comrades.springtime.module;

public enum Role {

    ROLE_STUDENT("STUDENT"),
    ROLE_MENTOR("MENTOR"),
    ROLE_MODERATOR("MODERATOR");


    private String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }

}
