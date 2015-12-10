package com.jason.pos;

import com.jason.pos.Parser.ItemParser;
import com.jason.pos.model.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemParserTest {

    @Test
    public void test_parse_should_return_list_item_when_input_list_String() throws Exception {
        List<String> input = new ArrayList<String>();
        input.add("ITEM000001:40");
        input.add("ITEM000003:50");
        input.add("ITEM000005:60");
        ItemParser itemParser = new ItemParser();

        List<Item> result = itemParser.parse(input);

        assertThat(result.size(),is(input.size()));
        assertThat(result.get(0).getCode(),is("ITEM000001"));
        assertThat(result.get(0).getPrice(),is(40.0));
    }
}
