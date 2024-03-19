package com.example.upvote.service;

import com.example.upvote.domain.entity.CustomUser;
import com.example.upvote.domain.entity.Idea;
import com.example.upvote.dto.incoming.IdeaCreationCommand;
import com.example.upvote.dto.outgoing.IdeaDetails;
import com.example.upvote.dto.outgoing.IdeaList;
import com.example.upvote.repository.CustomUserRepository;
import com.example.upvote.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final CustomUserRepository customUserRepository;


    public void saveNewIdea(IdeaCreationCommand command) {
        Idea idea = ideaRepository.save(new Idea(command));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails loggedInUser = (User) authentication.getPrincipal();
        CustomUser customUser = customUserRepository.findCustomUserByUsername(loggedInUser.getUsername());
        customUser.getIdeasOfUser().add(idea);
        idea.setOwner(customUser);
    }

    public List<IdeaDetails> listAllIdeas() {
        List<Idea> ideas = ideaRepository.findAll();

        return ideas.stream().filter(Idea::isVisible).map(IdeaDetails::new).collect(Collectors.toList());
    }

    public void acceptIdea(Long id) {
        Optional<Idea> idea = ideaRepository.findById(id);

        if (idea.isPresent() && !idea.get().isVisible() && !idea.get().isDeleted()){
            idea.get().setVisible(true);
            idea.get().setDeleted(false);
        }
    }

    public void rejectIdea(Long id) {
        Optional<Idea> idea = ideaRepository.findById(id);

        if (idea.isPresent() && !idea.get().isVisible() && !idea.get().isDeleted()){
            idea.get().setVisible(false);
            idea.get().setDeleted(true);
        }
    }

    public List<IdeaList> listAllNewIdea() {
        List<Idea> ideas = ideaRepository.findAll();

        return ideas.stream().filter(idea -> !idea.isDeleted()).map(IdeaList::new).collect(Collectors.toList());
    }

    public void addVote(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails loggedInUser = (User) authentication.getPrincipal();
        CustomUser customUser = customUserRepository.findCustomUserByUsername(loggedInUser.getUsername());

        Optional<Idea> idea = ideaRepository.findById(id);

        idea.get().getUsers().add(customUser);
        customUser.getVoted().add(idea.get());
    }
}
