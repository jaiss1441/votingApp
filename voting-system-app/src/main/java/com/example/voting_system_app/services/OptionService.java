package com.example.voting_system_app.services;

import com.example.voting_system_app.entity.Option1;
import com.example.voting_system_app.repo.OptionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OptionService {

//    @Autowired
//    private VoteRepo voteRepo;

    @Autowired
    private OptionRepo optionRepo;

    public List<Option1> getAllOption(){
        return optionRepo.findAll();
    }

    public void createVote(int optionId){
       Option1 option= optionRepo.findById(optionId).orElseThrow();
       option.setVotes(option.getVotes()+1);
       optionRepo.save(option);
    }

}
