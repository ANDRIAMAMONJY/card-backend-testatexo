package com.cardgenerator.game.service;

import java.util.Collection;

import com.cardgenerator.game.common.Card;
import com.cardgenerator.game.common.CardCollections;
import com.cardgenerator.game.common.CardColor;
import com.cardgenerator.game.common.CardValue;
import com.cardgenerator.game.common.GameOrderChoice;
import com.cardgenerator.game.common.HandCard;
import com.cardgenerator.game.controllers.reponse.GameResponse;
import com.cardgenerator.game.form.CardForm;
import com.cardgenerator.game.form.GameForm;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameResponse solve(GameForm form) {
        Card[] cards = validateCard(form.getCards());
        CardColor[] colorOrders = validateColorOrder(form.getColor_orders());
        CardValue[] valueOrders = validateValueOrder(form.getValue_orders());

        Card[] ordereds = cards.clone();
        
        if (validateGameChoice(form.getChoice()) == GameOrderChoice.COLOR) {
            CardCollections.sort(ordereds, colorOrders, valueOrders);
        } else {
            CardCollections.sort(ordereds, valueOrders, colorOrders);
        }

        return new GameResponse(
            cards,
            ordereds,
            colorOrders,
            valueOrders
        );
    }

    private Card[] validateCard(CardForm[] cards) {
        if (cards == null || cards.length == 0) {
            return new HandCard().generate(10);
        }

        final Card[] ans = new Card[cards.length];

        for (int i = 0; i < cards.length; i++) {
            CardForm form = cards[i];
            if (form.getColor() == null || form.getValue() == null) {
                throw new IllegalArgumentException("Given card at cards["+ i +"] is not a valid card because one of 'color' or 'value' is null.");
            }
            ans[i] = new Card(form.getColor(), form.getValue());
        }

        return ans;
    }

    private CardColor[] validateColorOrder(Collection<CardColor> colorOrders) {
        if (colorOrders == null || colorOrders.isEmpty()) {
            return CardCollections.generate(CardColor.values()).toArray(new CardColor[0]);
        }
        return colorOrders.toArray(new CardColor[0]);
    }
    
    private CardValue[] validateValueOrder(Collection<CardValue> valueOrders) {
        if (valueOrders == null || valueOrders.isEmpty()) {
            return CardCollections.generate(CardValue.values()).toArray(new CardValue[0]);
        }
        return valueOrders.toArray(new CardValue[0]);
    }

    private GameOrderChoice validateGameChoice(GameOrderChoice choice) {
        if (choice == null) {
            return GameOrderChoice.COLOR;
        }
        return choice;
    }
}
