package com.jason.pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosSystem {
    private List<Item> items;
    private FileReader fileReader;
    private Parser<Item> itemParser;
    private Map<String, PromotionChain> promotionMap;
    private SecondHalfPricePromotionItemParser secondHalfPricePromotionItemParser;
    private DiscountPromotionParser discountPromotionParser;

    public PosSystem() {
        this.items = new ArrayList<Item>();
        this.fileReader = new FileReader();
        this.itemParser = new ItemParser();
        secondHalfPricePromotionItemParser = new SecondHalfPricePromotionItemParser();
        discountPromotionParser = new DiscountPromotionParser();
    }

    public List<Item> readItemFile(String itemListFile) {
        items = itemParser.parse(fileReader.read(itemListFile));
        return items;
    }

    public List<Item> getItems() {
        return items;
    }

    public Map<String, PromotionChain> getPromotionMap() {
        return promotionMap;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, PromotionChain> readSecondHalfPricePromotionFile(String promotionItemListFile) {
        checkAndCreatePromotionMap();
        List<Item> promotionItems = secondHalfPricePromotionItemParser.parse(fileReader.read(promotionItemListFile));
        for (Item promotionItem : promotionItems) {
            boundSecondHalfPrecePromotionToItem(promotionItem);
        }
        return promotionMap;
    }


    public Map<String, PromotionChain> readDiscountPromotionFile(String discountPromotionFile) {
        checkAndCreatePromotionMap();
        List<Map<String, Promotion>> discountPromotion = discountPromotionParser.parse(fileReader.read(discountPromotionFile));
        for (Map<String, Promotion> stringPromotionMap : discountPromotion) {
            boundDiscountPromotionToItem(stringPromotionMap);
        }
        return promotionMap;
    }

    private void boundSecondHalfPrecePromotionToItem(Item promotionItem) {
        if (promotionMap.get(promotionItem.getCode()) == null) {
            PromotionChain promotionChain = new PromotionChain();
            promotionChain.addPromotion(new SecondHalfPromotion());
            promotionMap.put(promotionItem.getCode(), promotionChain);
        } else {
            promotionMap.get(promotionItem.getCode()).addPromotion(new SecondHalfPromotion());
        }
    }

    private void boundDiscountPromotionToItem(Map<String, Promotion> stringPromotionMap) {
        for (String key : stringPromotionMap.keySet()) {
            if (promotionMap.containsKey(key)) {
                promotionMap.get(key).addPromotion(stringPromotionMap.get(key));
            } else {
                PromotionChain promotionChain = new PromotionChain();
                promotionChain.addPromotion(stringPromotionMap.get(key));
                promotionMap.put(key, promotionChain);
            }
        }
    }

    private void checkAndCreatePromotionMap() {
        if (null == promotionMap) {
            promotionMap = new HashMap<String, PromotionChain>();
        }
    }

    public void init() {
        readItemFile(this.getClass().getClassLoader().getResource("itemlist.txt").getPath());
        readDiscountPromotionFile(this.getClass().getClassLoader().getResource("discount_promotion.txt").getPath());
        readSecondHalfPricePromotionFile(this.getClass().getClassLoader().getResource("second_half_price_promotion.txt").getPath());
    }

    public double caculate() {
        List<CarItem> carItems = readCarItemFile(this.getClass().getClassLoader().getResource("car.txt").getPath());
        for (Item item : items) {
            for (CarItem carItem : carItems) {
                if (item.getCode().equals(carItem.getItem().getCode())) {
                    carItem.setItem(item);
                }
            }
        }
        double result = 0;
        for (CarItem carItem : carItems) {
            if (promotionMap.containsKey(carItem.getItem().getCode())) {
                promotionMap.get(carItem.getItem().getCode()).promote(carItem);
            }
            result += (carItem.getItem().getPrice() * carItem.getAmount());
        }
        return result;
    }

    private List<CarItem> readCarItemFile(String carItemFile) {
        List<CarItem> result = null;
        CarItemParser carItemParser = new CarItemParser();
        result = carItemParser.parse(fileReader.read(carItemFile));
        return result;
    }

}
