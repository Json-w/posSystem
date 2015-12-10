package com.jason.pos.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser<T> {
    public List<T> parse(List<String> itemLines) {
        List<T> result = new ArrayList<T>();
        for (String itemLine : itemLines) {
            result.add(parseLine(itemLine));
        }
        return result;
    }

    public abstract T parseLine(String itemLine);

}
