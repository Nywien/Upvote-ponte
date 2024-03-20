package com.example.upvote.dto.outgoing;

import com.example.upvote.domain.entity.Idea;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdeaList {

    private Long id;
    private String name;
    private String owner;
    private String descriptionOfIdea;

    public IdeaList(Idea idea) {
        this.id = idea.getIdeaId();
        this.name = idea.getName();
        this.owner = idea.getOwner().getFirstName() + " " + idea.getOwner().getLastName();
        this.descriptionOfIdea = idea.getDescriptionOfIdea();
    }
}
