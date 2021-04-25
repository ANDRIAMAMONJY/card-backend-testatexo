package com.cardgenerator.game.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class CardCollections {

    private CardCollections() {

    }

    /**
     * private final Random random = new Random();
    public <T> T[] generate(T[] colors) {
        T[] orders = colors.clone();
        for (int i = 0; i < orders.length; i++) {
            int nextIndexToSwap = random.nextInt(orders.length);
            T tmp = orders[nextIndexToSwap];
            orders[nextIndexToSwap] = orders[i];
            orders[i] = tmp;
        }
        return orders;
    }*/

    /**
     * Shuffle the given arr using the method @see Collections#shuffle(List).
     * 
     * This method does not change the orders of the array parameters.
     * 
     * @param <T> The type of the arrys to shuffle
     * @param arr The array to shuffle
     * @return
     */
    public static <T> List<T> generate(T[] arr) {
        List<T> randArr = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(randArr);
        return Collections.unmodifiableList(randArr);
    }

    /**
     * Sort the cards by color first
     * 
     * @param cards
     * @param colorOrders
     * @param valOrders
     */
    public static void sort(Card[] cards, CardColor[] colorOrders, CardValue[] valOrders) {
        final Map<CardColor, Integer> colorWeights = getWeights(colorOrders, CardColor.class);
        final Map<CardValue, Integer> valueWeights = getWeights(valOrders, CardValue.class);

        Arrays.sort(cards, colorFirst(colorWeights, valueWeights));
    }
    
    /**
     * SOrt the cards by value first
     * 
     * @param cards
     * @param colorOrders
     * @param valOrders
     */
    public static void sort(Card[] cards, CardValue[] valOrders, CardColor[] colorOrders) {
        final Map<CardColor, Integer> colorWeights = getWeights(colorOrders, CardColor.class);
        final Map<CardValue, Integer> valueWeights = getWeights(valOrders, CardValue.class);

        Arrays.sort(cards, valueFirst(colorWeights, valueWeights));
    }

    private static <T extends java.lang.Enum<T>> Map<T, Integer> getWeights(T[] valOrders, Class<T> enumClass) {
        final Map<T, Integer> weights = new EnumMap<>(enumClass);
        int w = 0;
        for (T cardOrder : valOrders) {
            weights.put(cardOrder, w++);
        }
        return weights;
    }

    private static Comparator<Card> colorFirst(Map<CardColor, Integer> colorWeights, Map<CardValue, Integer> valueWeights) {
        return (a, b) -> {
            int weightA = colorWeights.getOrDefault(a.getColor(), -1);
            int weightB = colorWeights.getOrDefault(b.getColor(), -1);
            if (weightA == weightB) {
                weightA = valueWeights.getOrDefault(a.getValue(), -1);
                weightB = valueWeights.getOrDefault(b.getValue(), -1);
            }
            return weightA - weightB;
        };
    }

    private static Comparator<Card> valueFirst(Map<CardColor, Integer> colorWeights, Map<CardValue, Integer> valueWeights) {
        return (a, b) -> {
            int weightA = valueWeights.getOrDefault(a.getValue(), -1);
            int weightB = valueWeights.getOrDefault(b.getValue(), -1);
            if (weightA == weightB) {
                weightA = colorWeights.getOrDefault(a.getColor(), -1);
                weightB = colorWeights.getOrDefault(b.getColor(), -1);
            }
            return weightA - weightB;
        };
    }
}
