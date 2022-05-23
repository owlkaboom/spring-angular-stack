package com.owlkaboom.springangular.game;

import com.owlkaboom.springangular.game.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
