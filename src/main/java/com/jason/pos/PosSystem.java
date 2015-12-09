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

    public PosSystem() {
        this.items = new ArrayList<Item>();
        this.fileReader = new FileReader();
        this.itemParser = new ItemParser();
        secondHalfPricePromotionItemParser = new SecondHalfPricePromotionItemParser();
    }

    public List<Item> readItemFile(String itemListFile) {
        return itemParser.parse(fileReader.read(itemListFile));
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, PromotionChain> readSecondHalfPricePromotionFile(String promotionItemListFile) {
        Map<String, PromotionChain> result = promotionMap;
        if (null == result) {
            result = new HashMap<String, PromotionChain>();
        }
        List<Item> promotionItems = secondHalfPricePromotionItemParser.parse(fileReader.read(promotionItemListFile));
        for (Item promotionItem : promotionItems) {
            if (result.get(promotionItem.getCode()) == null) {
                PromotionChain promotionChain = new PromotionChain();
                promotionChain.addPromotion(new SecondHalfPromotion());
                result.put(promotionItem.getCode(), promotionChain);
            } else {
                result.get(promotionItem.getCode()).addPromotion(new SecondHalfPromotion());
            }
        }
        return result;
    }
}
