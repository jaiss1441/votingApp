//package com.example.voting_system_app.entity;
//
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class Vote {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    private int pollId;
//
//    @ManyToOne
//    @JoinColumn(name = "option_id")
//    private List<Option> optionList;
//}
