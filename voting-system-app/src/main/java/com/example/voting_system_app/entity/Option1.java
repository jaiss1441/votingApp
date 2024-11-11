package com.example.voting_system_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Option1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String desc1;

    private int votes;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

}
