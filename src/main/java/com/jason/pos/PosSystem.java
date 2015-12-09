package com.jason.pos;

import java.util.ArrayList;
import java.util.List;

public class PosSystem {
    private List<Item> items;
    private FileReader fileReader;
    private Parser<Item> itemParser;

    public PosSystem() {
        this.items = new ArrayList<Item>();
        this.fileReader = new FileReader();
        this.itemParser = new ItemParser();
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
}
