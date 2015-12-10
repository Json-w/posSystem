package com.jason.pos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPromotionTest {
    @Test
    public void test_promote_should_return_save_money_when_input_2_second_half_promotion_item() throws Exception {
        SecondHalfPromotion secondHalfPromotion = new SecondHalfPromotion();
        CarItem secondHalfPromotionItem = new CarItem(new Item("ITEM000001", 40), 2);

        double saveMoney = secondHalfPromotion.promote(secondHalfPromotionItem);

        assertThat(saveMoney,is(20.0));
    }

    @Test
    public void test_promote_should_return_20_when_input_3_second_half_promotion_item() throws Exception {
        SecondHalfPromotion secondHalfPromotion = new SecondHalfPromotion();
        CarItem secondHalfPromotionItem = new CarItem(new Item("ITEM000001", 40), 3);

        double saveMoney = secondHalfPromotion.promote(secondHalfPromotionItem);

        assertThat(saveMoney,is(20.0));
    }
}
