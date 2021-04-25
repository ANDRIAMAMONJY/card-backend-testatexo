package com.cardgenerator.game.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandCardTest {
    @Test
    public void testGenerateHandCard()
    {
        HandCard driver = new HandCard();
        Card[] hands1 = driver.generate(10);
        Card[] hands2 = driver.generate(10);
        Card[] hands3 = driver.generate(10);
        assertThat(hands1).hasSize(10);
        assertThat(hands2).hasSize(10);
        assertThat(hands3).hasSize(10);
        assertThat(hands1).hasSize(10);
        assertThat(hands2).isNotEqualTo(hands1);
        assertThat(hands3).isNotEqualTo(hands1);
        assertThat(hands2).isNotEqualTo(hands3);
    }
}
