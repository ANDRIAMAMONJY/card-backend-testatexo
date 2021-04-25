package com.cardgenerator.game.form;

import com.cardgenerator.game.common.CardColor;
import com.cardgenerator.game.common.CardValue;

public class CardForm {
    private CardColor color;
    private CardValue value;

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }
}
