package com.jason.pos.Parser;

import com.jason.pos.model.Item;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser extends Parser<Item> {
    private final Pattern PATTERN = Pattern.compile("^(\\w+):(\\d+)$");


    public Item parseLine(String itemLine) {
        Matcher matcher = PATTERN.matcher(itemLine);
        if (matcher.matches()) {
            Item item = new Item(matcher.group(1), Double.parseDouble(matcher.group(2)));
            return item;
        } else {
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
