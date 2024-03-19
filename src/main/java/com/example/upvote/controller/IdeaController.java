package com.example.upvote.controller;

import com.example.upvote.dto.incoming.IdeaCreationCommand;
import com.example.upvote.dto.outgoing.IdeaDetails;
import com.example.upvote.dto.outgoing.IdeaList;
import com.example.upvote.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @PostMapping
    @Secured("ROLE_VOTER")
    public ResponseEntity<Void> createIdea(@RequestBody IdeaCreationCommand command) {
        ideaService.saveNewIdea(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IdeaDetails>> getListOfIdeas() {
        List<IdeaDetails> ideaDetailsList = ideaService.listAllIdeas();
        return new ResponseEntity<>(ideaDetailsList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Secured("ROLE_VOTER")
    public ResponseEntity<Void> addVote(@PathVariable Long id) {
        ideaService.addVote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/listAllNewIdea")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<IdeaList>> listAllNewIdea() {
        List<IdeaList> ideaList = ideaService.listAllNewIdea();
        return new ResponseEntity<>(ideaList, HttpStatus.OK);
    }

    @PatchMapping("/ideas/{id}/accept")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Void> acceptIdea(@PathVariable Long id) {
        ideaService.acceptIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/ideas/{id}/reject")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Void> rejectIdea(@PathVariable Long id) {
        ideaService.rejectIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
