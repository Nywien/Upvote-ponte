package com.example.upvote.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomUserCreationCommand {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;
}
