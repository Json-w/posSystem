package com.jason.pos;

import com.jason.pos.Parser.DiscountPromotionParser;
import com.jason.pos.Parser.Parser;
import com.jason.pos.promotion.Promotion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiscountPromotionParserTest {
    @Test
    public void test_promote_should_return_list_map_contains_item_code_and_promotion_when_input_disocont_promotion_info_list() throws Exception {
        List<String> discountPromotionList = new ArrayList<String>();
        discountPromotionList.add("ITEM000001:75");
        discountPromotionList.add("ITEM000005:90");
        Parser discountPromotionParser = new DiscountPromotionParser();

        List<Map<String, Promotion>> result = discountPromotionParser.parse(discountPromotionList);

        assertThat(result.size(), is(2));
        assertThat(result.get(0).get("ITEM000001"), is(Promotion.class));
    }
}
