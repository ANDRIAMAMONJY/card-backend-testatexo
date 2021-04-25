package com.cardgenerator.game.common;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SortCardTest {
    Card asCarreaux = new Card(CardColor.CARREAUX, CardValue.AS);
    Card asCoeur = new Card(CardColor.COEUR, CardValue.AS);
    Card dameCarreaux = new Card(CardColor.CARREAUX, CardValue.DAME);
    Card dameCoeur = new Card(CardColor.COEUR, CardValue.DAME);
    Card dixCoeur = new Card(CardColor.COEUR, CardValue.DIX);
    Card dixCarreaux = new Card(CardColor.CARREAUX, CardValue.DIX);
    Card cinqCarreaux = new Card(CardColor.CARREAUX, CardValue.CINQ);
    Card cinqCoeur = new Card(CardColor.COEUR, CardValue.CINQ);

    private Card[] getCards() {
        return new Card[] {
            asCarreaux, asCoeur, dameCarreaux, dameCoeur, dixCoeur, dixCarreaux, cinqCoeur, cinqCarreaux
        };
    }

    private CardColor[] getColorOrders() {
        return new CardColor[] { CardColor.CARREAUX, CardColor.COEUR };
    }

    private CardValue[] getValueOrders() {
        return new CardValue[] { CardValue.AS, CardValue.DAME, CardValue.DIX, CardValue.CINQ};
    }

    @Test
    public void testSordCardDistinctValue() {
        Card[] cards = getCards();
        CardCollections.sort(cards, getColorOrders(), getValueOrders());
        assertThat(cards).containsExactly(asCarreaux, dameCarreaux, dixCarreaux, cinqCarreaux, asCoeur, dameCoeur, dixCoeur, cinqCoeur);
    }
    
    @Test
    public void testSordCardDistinctValueWithValueFirst() {
        Card[] cards = getCards();
        CardCollections.sort(cards, getValueOrders(), getColorOrders());
        assertThat(cards).containsExactly(asCarreaux, asCoeur, dameCarreaux, dameCoeur, dixCarreaux, dixCoeur, cinqCarreaux, cinqCoeur);
    }

    @Test
    public void testSordCardContainsDuplicateValue() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(Arrays.asList(getCards()));
        cards.addAll(Arrays.asList(getCards()));
        Card[] arr = cards.toArray(new Card[0]);

        CardCollections.sort(arr, getColorOrders(), getValueOrders());
        assertThat(arr).containsExactly(
            asCarreaux, asCarreaux, dameCarreaux, dameCarreaux, dixCarreaux, dixCarreaux, cinqCarreaux, cinqCarreaux,
            asCoeur, asCoeur, dameCoeur, dameCoeur, dixCoeur, dixCoeur, cinqCoeur, cinqCoeur
        );
    }
    
    @Test
    public void testSordCardContainsDuplicateValueWithValueFirst() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(Arrays.asList(getCards()));
        cards.addAll(Arrays.asList(getCards()));
        Card[] arr = cards.toArray(new Card[0]);

        CardCollections.sort(arr, getValueOrders(), getColorOrders());
        assertThat(arr).containsExactly(
            asCarreaux, asCarreaux, asCoeur, asCoeur, dameCarreaux, dameCarreaux, dameCoeur, dameCoeur,
            dixCarreaux, dixCarreaux, dixCoeur, dixCoeur, cinqCarreaux, cinqCarreaux, cinqCoeur, cinqCoeur
        );
    }
}
