package org.comrades.springtime.module;

public enum Role {

    STUDENT("STUDENT"),
    MENTOR("MENTOR"),
    MODERATOR("MODERATOR");

    private final String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }

}
