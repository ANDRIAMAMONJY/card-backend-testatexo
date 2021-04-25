package com.cardgenerator.game.controllers.reponse;

import com.cardgenerator.game.common.Card;
import com.cardgenerator.game.common.CardColor;
import com.cardgenerator.game.common.CardValue;

public class GameResponse {
    private final Card[] cards;
    private final Card[] ordereds;
    private final CardColor[] colors;
    private final CardValue[] values;

    public GameResponse(Card[] cards, Card[] ordereds, CardColor[] colors, CardValue[] values) {
        this.cards = cards;
        this.ordereds = ordereds;
        this.colors = colors;
        this.values = values;
    }

    public Card[] getCards() {
        return cards;
    }

    public CardColor[] getColors() {
        return colors;
    }

    public CardValue[] getValues() {
        return values;
    }

    public Card[] getOrdereds() {
        return ordereds;
    }
}
