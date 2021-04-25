package com.cardgenerator.game.common;

public class Card {
    private final CardValue value;
    private final CardColor color;

    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }
    
    public CardColor getColor() {
        return color;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return color == other.color && value == other.getValue();
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(value.toString()).append('(')
            .append(color.name()).append(')').toString();
    }
}
