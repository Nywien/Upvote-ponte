package com.example.upvote.dto.outgoing;

import com.example.upvote.domain.entity.Idea;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdeaDetails {

    private Long id;
    private String owner;
    private String descriptionOfIdea;
    private int votes;

    public IdeaDetails(Idea idea) {
        this.id = idea.getIdeaId();
        this.owner = idea.getOwner().getFirstName() + " " + idea.getOwner().getLastName();
        this.descriptionOfIdea = idea.getDescriptionOfIdea();
        this.votes = idea.getUsers().size();
    }
}
