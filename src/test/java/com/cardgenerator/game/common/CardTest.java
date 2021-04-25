package com.cardgenerator.game.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    public void testEquality() {
        Card x = new Card(CardColor.CARREAUX, CardValue.AS);
        Card y = new Card(CardColor.CARREAUX, CardValue.AS);
        Card z = new Card(CardColor.CARREAUX, CardValue.AS);
        assertThat(x).isEqualTo(x).isEqualTo(y).isEqualTo(z);

        Set<Card> cards = new HashSet<>();
        cards.add(x);
        cards.add(y);
        cards.add(z);
        assertThat(cards).hasSize(1).contains(x).contains(y).contains(z);
    }

    @Test
    public void testInequality() {
        Card x = new Card(CardColor.CARREAUX, CardValue.AS);
        Card y = new Card(CardColor.COEUR, CardValue.AS);
        Card z = new Card(CardColor.CARREAUX, CardValue.DIX);
        Card t = new Card(CardColor.COEUR, CardValue.DIX);
        Card[][] inequalities = new Card[][] {{x, y}, {x, z}, {x, t}, {y, z}, {y, t}, {z, t}};
        for (Card[] cards : inequalities) {
            assertThat(cards[0]).isNotEqualTo(cards[1]);
            assertThat(cards[1]).isNotEqualTo(cards[0]);
        }
        Card no = null;
        assertThat(no).isNotEqualTo(x);

        Set<Card> cards = new HashSet<>();
        cards.add(x);
        cards.add(y);
        cards.add(z);
        cards.add(t);
        cards.add(t);
        assertThat(cards).hasSize(4).contains(x).contains(y).contains(z).contains(t);
    }
}
