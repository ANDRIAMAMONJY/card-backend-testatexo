package com.cardgenerator.game.common;

public enum CardValue {
    AS("A"),
    DAME("Q"),
    VALET("J"),
    ROI("K"),
    DIX("10"),
    NEUF("9"),
    HUIT("8"),
    SEPT("7"),
    SIX("6"),
    CINQ("5"),
    QUATRE("4"),
    TROIS("3"),
    DEUX("2");

    private char[] strValue;

    CardValue(String strVal) {
        this.strValue = strVal.toCharArray();
    }

    @Override
    public String toString() {
        return String.valueOf(strValue);
    }
}
