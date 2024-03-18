package com.example.upvote.domain.enums;

public enum UserRole {

    ROLE_ADMIN,
    ROLE_VOTER;

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
