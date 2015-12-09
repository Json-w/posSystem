package com.jason.pos;

public class SecondHalfPromotion implements Promotion {
    public double promote(CarItem secondHalfPromotionItem) {
        double saveMoney;
        double afterPromotedPrice = caculateAfterPromotedPrice(secondHalfPromotionItem);
        saveMoney = secondHalfPromotionItem.getItem().getPrice() * secondHalfPromotionItem.getAmount() - afterPromotedPrice;
        return saveMoney;
    }

    private double caculateAfterPromotedPrice(CarItem secondHalfPromotionItem) {
        double result = 0;
        result += secondHalfPromotionItem.getItem().getPrice() * secondHalfPromotionItem.getAmount();
        if (secondHalfPromotionItem.getAmount() >= 2) {
            result -= (secondHalfPromotionItem.getAmount() / 2) * secondHalfPromotionItem.getItem().getPrice() * 0.5;
        }
        return result;
    }
}
