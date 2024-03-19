package com.example.upvote.controller;

import com.example.upvote.dto.incoming.CustomUserCreationCommand;
import com.example.upvote.dto.outgoing.CustomUserDetails;
import com.example.upvote.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserService customUserService;

    @PostMapping
    //@Secured("ROLE_VOTER")
    public ResponseEntity<Void> createNewUser(@RequestBody CustomUserCreationCommand command) {
        customUserService.register(command);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/me")
    public ResponseEntity<CustomUserDetails> getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails loggedInUser = (User) authentication.getPrincipal();
        CustomUserDetails customUserDetails = customUserService.getCustomUserDetailsByUsername(loggedInUser.getUsername());

        return new ResponseEntity<>(customUserDetails, HttpStatus.OK);
    }
}
