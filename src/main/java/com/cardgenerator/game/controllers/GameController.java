package com.cardgenerator.game.controllers;

import com.cardgenerator.game.common.Card;
import com.cardgenerator.game.common.CardContainer;
import com.cardgenerator.game.common.HandCard;
import com.cardgenerator.game.controllers.reponse.GameResponse;
import com.cardgenerator.game.form.GameForm;
import com.cardgenerator.game.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    
    private @Autowired GameService gameService;

    /**
     * Get all cards action
     * 
     * @return
     */
    @GetMapping("cards")
    public Card[] getAllCards() {
        return CardContainer.all();
    }

    /**
     * Get all cards action
     * 
     * @return
     */
    @GetMapping("hand/{size:[1-9][0-9]?}")
    public Card[] getHandContents(@PathVariable("size") int size) {
        return new HandCard().generate(size);
    }

    /**
     * Resolve given game. If the param is not given. The engine generate all needed.
     * 
     * @param form
     * @return
     */
    @PostMapping("solve")
    public GameResponse resolve(GameForm form) {
        return gameService.solve(form);
    }

    /**
     * Generate a default game and resolve it.
     * 
     * @return
     */
    @GetMapping
    public GameResponse resolveAndGenerate() {
        return gameService.solve(new GameForm());
    }
}
