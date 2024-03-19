package com.example.upvote.domain.entity;

import com.example.upvote.dto.incoming.IdeaCreationCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_id")
    private Long ideaId;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private CustomUser owner;

    @Column(name = "description_of_idea")
    private String descriptionOfIdea;

    @ManyToMany(mappedBy = "voted")
    private List<CustomUser> users;

    @Column(name = "is_visible")
    private boolean isVisible = false;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public Idea(IdeaCreationCommand command) {
        this.name = command.getName();
        this.descriptionOfIdea = command.getDescriptionOfIdea();
    }
}
