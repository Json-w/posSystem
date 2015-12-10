package com.jason.pos.promotion;

import com.jason.pos.model.CarItem;

public class DiscountPromotion implements Promotion {
    private double discount;

    public DiscountPromotion(double discount) {
        this.discount = discount / 100;
    }

    public double promote(CarItem carItem) {
        double saveMoney;
        double afterPromotedPrice = caculatePriceAfterPromoted(carItem);
        saveMoney = carItem.getItem().getPrice()*carItem.getAmount() - afterPromotedPrice*carItem.getAmount();
        carItem.getItem().setPrice(afterPromotedPrice);
        return saveMoney;
    }

    private double caculatePriceAfterPromoted(CarItem carItem) {
        return carItem.getItem().getPrice() * discount;
    }
}
