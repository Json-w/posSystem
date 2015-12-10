package com.jason.pos;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscountPromotionParser extends Parser<Map<String, Promotion>> {
    private final Pattern PATTERN = Pattern.compile("^(\\w+):(\\d+)$");

    @Override
    public Map<String, Promotion> parseLine(String itemLine) {
        Map<String, Promotion> result = new HashMap<String, Promotion>();
        Matcher matcher = PATTERN.matcher(itemLine);
        if (matcher.matches()) {
            result.put(matcher.group(1), new DiscountPromotion(Double.parseDouble(matcher.group(2))));
        } else {
            throw new IllegalArgumentException("invalid input format");
        }
        return result;
    }
}
