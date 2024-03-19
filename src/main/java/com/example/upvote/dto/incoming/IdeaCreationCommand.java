package com.example.upvote.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdeaCreationCommand {

    private String descriptionOfIdea;
}
