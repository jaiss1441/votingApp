package com.example.voting_system_app.controller;

import com.example.voting_system_app.entity.Option1;
import com.example.voting_system_app.entity.Poll;
import com.example.voting_system_app.provider.PollData;
import com.example.voting_system_app.services.OptionService;
import com.example.voting_system_app.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollController {

    @Autowired
    private OptionService optionService;

    @Autowired
    private PollService pollService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("polls",pollService.getAllPoll());
        return "index";
    }

    @GetMapping("/poll/{id}")
    public String viewPoll(@PathVariable int id, Model model){
        model.addAttribute("poll", pollService.getPollbyId(id));
        return "poll";
    }
    @PostMapping("/poll")
    public String createPoll(@ModelAttribute PollData pollData){
        Poll poll = new Poll();
        poll.setQuestion(pollData.getQuestion());

        List<Option1> optionList = new ArrayList<>();
        for(String optionStr : pollData.getOptions1()){
            Option1 option = new Option1();
            option.setDesc1(optionStr);
            option.setPoll(poll);

            optionList.add(option);
        }
        poll.setOptionList(optionList);
        pollService.createPoll(poll);

        return "redirect:/";
    }

    @PostMapping("/vote")
    public String createVote(int optionId){
        optionService.createVote(optionId);

        return "redirect:/";
    }
    @GetMapping("/poll/{id}/result")
    public String pollResult(@PathVariable int id, Model model){
        model.addAttribute("poll", pollService.getPollbyId(id));
        return "result";
    }


}
