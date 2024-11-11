package com.example.voting_system_app.services;

import com.example.voting_system_app.entity.Poll;
import com.example.voting_system_app.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PollService {

    @Autowired
    private PollRepo pollRepo;

    public List<Poll> getAllPoll(){
        return pollRepo.findAll();
    }

    public Poll getPollbyId(int id){
        return pollRepo.findById(id).orElseThrow();
    }

    public void createPoll(Poll poll){
        pollRepo.save(poll);
    }
}