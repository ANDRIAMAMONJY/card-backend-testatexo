package com.cardgenerator.game.controllers;

import com.cardgenerator.game.common.CardColor;
import com.cardgenerator.game.common.CardCollections;
import com.cardgenerator.game.common.CardValue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/orders")
@RestController
public class OrderController {
    
    /**
     * This method show an example of color order
     * 
     * @return
     */
    @GetMapping("colors")
    public CardColor[] colorOrders() {
        return CardCollections.generate(CardColor.values()).toArray(new CardColor[0]);
    }
    
    /**
     * This method show an example of value order
     * 
     * @return
     */
    @GetMapping("values")
    public CardValue[] valueOrders() {
        return CardCollections.generate(CardValue.values()).toArray(new CardValue[0]);
    }
}
