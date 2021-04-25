package com.cardgenerator.game.common;

/**
 * This class follow singleton pattern.
 */
public class CardContainer {
    private static final Card[] cards;

    static {
        cards = generateAll();
    }

    private CardContainer() {
        //
    }

    /**
     * Get all possible card
     * 
     * Time complexity: O(mn)
     *  - m: The card color length
     *  - n: The card value length
     * 
     * @return
     */
    private static Card[] generateAll() {
        CardColor[] colors = CardColor.values();
        CardValue[] values = CardValue.values();
        Card[] ans = new Card[colors.length * values.length];
        int ansIndex = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < values.length; j++) {
                ans[ansIndex++] = new Card(colors[i], values[j]);
            }
        }
        return ans;
    }
    
    public static Card[] all() {
        return cards;
    }
}
