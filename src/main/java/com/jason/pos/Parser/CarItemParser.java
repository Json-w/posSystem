package com.jason.pos.Parser;

import com.jason.pos.model.CarItem;
import com.jason.pos.model.Item;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarItemParser extends Parser {
    private final Pattern PATTERN = Pattern.compile("^(\\w+)-(\\d+)$");
    private CarItem carItem;

    public CarItem parseLine(String carItemLine) {
        Matcher matcher = PATTERN.matcher(carItemLine);
        if (matcher.matches()) {
            carItem = new CarItem(new Item(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } else {
            carItem = new CarItem(new Item(matcher.group(1)), 1);
        }
        return carItem;
    }
}
