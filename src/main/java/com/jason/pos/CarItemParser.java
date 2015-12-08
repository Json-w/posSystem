package com.jason.pos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarItemParser extends Parser{
    private final Pattern PATTERN = Pattern.compile("^(\\w+)-(\\d+)$");

    public CarItem parseLine(String carItemLine) {
        Matcher matcher = PATTERN.matcher(carItemLine);
        if (matcher.matches()) {
            CarItem carItem = new CarItem(new Item(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            return carItem;
        } else {
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
