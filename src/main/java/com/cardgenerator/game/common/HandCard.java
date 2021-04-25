package com.cardgenerator.game.common;

import java.util.Arrays;

public class HandCard {
    private Card[] allCards;

    public HandCard() {
        allCards = CardContainer.all();
    }

    public HandCard(Card[] cards) {
        this.allCards = cards;        
    }

    /**
     * Get a random list of card.
     * 
     * @param number The length of the desired list.
     * @return
     */
    public Card[] generate(int number) {
        if (this.allCards == null || this.allCards.length < number) {
            throw new IllegalStateException("card insufficient for generating the desired number: " + number);
        }
        if (number < 0) {
            throw new IllegalArgumentException("The desired number " + number + " was not invalid.");
        }
        Card[] allCardsPerms = CardCollections.generate(this.allCards).toArray(new Card[0]);
        return Arrays.copyOf(allCardsPerms, number);
    }
}
