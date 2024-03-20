package com.example.upvote.domain.entity;

import com.example.upvote.domain.enums.UserRole;
import com.example.upvote.dto.incoming.CustomUserCreationCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "custom_user")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @OneToMany(mappedBy = "owner")
    private List<Idea> ideasOfUser;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_idea",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "idea_id") }
    )
    private List<Idea> voted;

    public CustomUser(CustomUserCreationCommand command) {
        this.username = command.getUsername();
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.password = command.getPassword();
        this.email = command.getEmail();
    }
}
