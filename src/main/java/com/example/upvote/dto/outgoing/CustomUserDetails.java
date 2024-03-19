package com.example.upvote.dto.outgoing;

import com.example.upvote.domain.entity.CustomUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomUserDetails {

    private Long customUserId;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    public CustomUserDetails(CustomUser user) {
        this.customUserId = user.getUserId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole().getDisplayName();
    }
}
