package com.jason.pos.promotion;

import com.jason.pos.model.CarItem;

import java.util.ArrayList;
import java.util.List;

public class PromotionChain implements Promotion {
    private List<Promotion> promotions = new ArrayList<Promotion>();

    @Override
    public double promote(CarItem carItem) {
        double saveMoney = 0;
        if (promotions.size() > 0) {
            for (Promotion promotion : promotions) {
                saveMoney += promotion.promote(carItem);
            }
        }
        return saveMoney;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }
}
