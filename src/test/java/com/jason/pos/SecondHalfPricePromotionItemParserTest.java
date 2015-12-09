package com.jason.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPricePromotionItemParserTest {

    @Test
    public void test_parse_should_return_promotion_list_item_when_promotion_line_list() throws Exception {
        List<String> secondHalfPricePromotionLines = new ArrayList<String>();
        secondHalfPricePromotionLines.add("ITEM000001");
        secondHalfPricePromotionLines.add("ITEM000003");
        Parser<Item> secondHalfPricePromotionParser = new SecondHalfPricePromotionItemParser();

        List<Item> result = secondHalfPricePromotionParser.parse(secondHalfPricePromotionLines);

        assertThat(result.size(), is(2));
        assertThat(result.get(0).getCode(), is("ITEM000001"));
        assertThat(result.get(0).getPrice(), is(0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_parse_should_throw_exception_when_input_invalid_promotion_line_list() {
        List<String> secondHalfPricePromotionLines = new ArrayList<String>();
        secondHalfPricePromotionLines.add("ijkdsf---");
        secondHalfPricePromotionLines.add("ITEM000003");
        Parser<Item> secondHalfPricePromotionParser = new SecondHalfPricePromotionItemParser();

        secondHalfPricePromotionParser.parse(secondHalfPricePromotionLines);

    }
}
