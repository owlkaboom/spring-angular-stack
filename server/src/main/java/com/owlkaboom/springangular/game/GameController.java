package com.owlkaboom.springangular.game;

import com.owlkaboom.springangular.game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public Iterable<Game> getGames(Principal principal) {
        Iterable<Game> allGames = gameRepository.findAll();
        if(principal != null) {
            System.out.println("Principal - " + principal.getName());
        }
        return allGames;
    }
}
