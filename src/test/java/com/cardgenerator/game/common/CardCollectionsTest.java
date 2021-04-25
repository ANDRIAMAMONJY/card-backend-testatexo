package com.cardgenerator.game.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CardCollectionsTest {

    @Test
    public void testGenerateColorOrder() {
        CardColor[] colors = CardColor.values();
        assertThat(CardCollections.generate(colors).toArray(new CardColor[0])).isNotEqualTo(colors);
    }
    
    @Test
    public void testGenerateValueOrder() {
        CardValue[] values = CardValue.values();
        assertThat(CardCollections.generate(values).toArray(new CardValue[0])).isNotEqualTo(values);
    }
}
