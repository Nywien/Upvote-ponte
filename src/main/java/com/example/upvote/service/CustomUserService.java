package com.example.upvote.service;

import com.example.upvote.domain.entity.CustomUser;
import com.example.upvote.domain.enums.UserRole;
import com.example.upvote.dto.incoming.CustomUserCreationCommand;
import com.example.upvote.dto.outgoing.CustomUserDetails;
import com.example.upvote.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(CustomUserCreationCommand command) {
        CustomUser customUser = new CustomUser(command);
        customUser.setRole(UserRole.ROLE_VOTER);
        customUser.setPassword(passwordEncoder.encode(command.getPassword()));
        customUserRepository.save(customUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomUser user = customUserRepository.findCustomUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getDisplayName())
                .build();
    }

    public CustomUserDetails getCustomUserDetailsByUsername(String username) {
        CustomUser customUser = customUserRepository.findCustomUserByUsername(username);
        return new CustomUserDetails(customUser);
    }
}
