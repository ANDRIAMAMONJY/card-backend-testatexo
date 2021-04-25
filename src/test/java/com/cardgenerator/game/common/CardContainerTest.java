package com.cardgenerator.game.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CardContainerTest {

    @Test
    public void testGenerateAllCards() {
        Card[] cards = CardContainer.all();
        // CardColor.values().length: 4
        // CardValue.values().length: 13
        assertThat(cards).hasSize(4 * 13);
    }

    @Test
    public void testAllCardsShouldBeUnique() {
        Card[] generateds = CardContainer.all();
        Set<Card> cards = new HashSet<>(Arrays.asList(generateds));
        assertThat(cards).hasSize(4 * 13).containsExactlyInAnyOrder(generateds);
        assertThat(CardContainer.all()).isEqualTo(generateds);
    }
}
