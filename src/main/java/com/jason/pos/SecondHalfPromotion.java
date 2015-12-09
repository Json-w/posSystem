package com.jason.pos;

import java.util.List;

public class SecondHalfPromotion {
    public double promote(List<CarItem> secondHalfPromotionItems) {
        double result = 0;
        for (CarItem secondHalfPromotionItem : secondHalfPromotionItems) {
            result += secondHalfPromotionItem.getItem().getPrice() * secondHalfPromotionItem.getAmount();
            if (secondHalfPromotionItem.getAmount() >= 2) {
                result -= (secondHalfPromotionItem.getAmount() / 2) * secondHalfPromotionItem.getItem().getPrice() * 0.5;
            }
        }
        return result;
    }
}
