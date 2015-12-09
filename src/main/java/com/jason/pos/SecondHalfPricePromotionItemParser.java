package com.jason.pos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondHalfPricePromotionItemParser extends Parser<Item>{
    private final Pattern PATTERN = Pattern.compile("^(\\w+)");
    @Override
    public Item parseLine(String itemLine) {
        Matcher matcher = PATTERN.matcher(itemLine);
        if(matcher.matches()){
            return new Item(matcher.group(1));
        }else {
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
