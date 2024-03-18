package com.example.upvote.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "idea")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_id")
    private Long ideaId;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private User owner;

    @Column(name = "description_of_idea")
    private String descriptionOfIdea;

    @Column(name = "votes")
    private int votes;
}
