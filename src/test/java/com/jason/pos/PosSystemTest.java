package com.jason.pos;

import com.jason.pos.promotion.PromotionChain;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PosSystemTest {
    @Test
    public void test_read_item_file_should_return_item_list_when_input_file_path() throws Exception {
        String itemListFile = this.getClass().getClassLoader().getResource("itemlist.txt").getPath();
        PosSystem posSystem = new PosSystem();

        assertThat(posSystem.readItemFile(itemListFile).size(), is(3));
    }

    @Test
    public void test_read_second_half_price_promotion_should_return_map_when_input_file_path() {
        String promotionItemListFile = this.getClass().getClassLoader().getResource("second_half_price_promotion.txt").getPath();
        PosSystem posSystem = new PosSystem();

        Map<String, PromotionChain> result = posSystem.readSecondHalfPricePromotionFile(promotionItemListFile);

        assertThat(result.get("ITEM000001"), is(PromotionChain.class));
    }

    @Test
    public void test_read_discount_promotion_file_should_return_map_when_input_file_path() throws Exception {
        String discountPromotionFile = this.getClass().getClassLoader().getResource("discount_promotion.txt").getPath();
        PosSystem posSystem = new PosSystem();

        Map<String, PromotionChain> result = posSystem.readDiscountPromotionFile(discountPromotionFile);

        assertThat(result.get("ITEM000001"), is(PromotionChain.class));
    }

    @Test
    public void test_initPosSystem_should_load_item_and_promotionMap() throws Exception {
        PosSystem posSystem = new PosSystem();

        posSystem.init();

        assertThat(posSystem.getItems().size(), is(3));
        assertThat(posSystem.getPromotionMap().get("ITEM000001").getPromotions().size(), is(2));
    }

    @Test
    public void test_caculate_should_return_price_after_promoted() throws Exception {
        PosSystem posSystem = new PosSystem();
        posSystem.init();

        double result = posSystem.caculate();

        assertThat(result, is(258.0));
    }
}
