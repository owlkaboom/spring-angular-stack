package com.owlkaboom.springangular.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Integer difficulty;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getDifficulty(){
        return difficulty;
    }
}
