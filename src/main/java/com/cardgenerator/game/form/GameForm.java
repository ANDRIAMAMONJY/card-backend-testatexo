package com.cardgenerator.game.form;

import java.util.Set;

import com.cardgenerator.game.common.CardColor;
import com.cardgenerator.game.common.CardValue;
import com.cardgenerator.game.common.GameOrderChoice;

public class GameForm {
    private CardForm[] cards;
    private Set<CardColor> color_orders;
    private Set<CardValue> value_orders;

    private GameOrderChoice choice;

    public CardForm[] getCards() {
        return cards;
    }

    public void setCards(CardForm[] cards) {
        this.cards = cards;
    }

    public Set<CardValue> getValue_orders() {
        return value_orders;
    }

    public void setValue_orders(Set<CardValue> value_orders) {
        this.value_orders = value_orders;
    }

    public Set<CardColor> getColor_orders() {
        return color_orders;
    }

    public void setColor_orders(Set<CardColor> color_orders) {
        this.color_orders = color_orders;
    }

    public GameOrderChoice getChoice() {
        return choice;
    }

    public void setChoice(GameOrderChoice choice) {
        this.choice = choice;
    }
}
