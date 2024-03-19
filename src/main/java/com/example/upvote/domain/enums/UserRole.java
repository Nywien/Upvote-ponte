package com.example.upvote.domain.enums;

public enum UserRole {

    ROLE_ADMIN("admin"),
    ROLE_VOTER("voter");

    private String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
