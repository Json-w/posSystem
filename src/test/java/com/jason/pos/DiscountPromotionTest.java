package com.jason.pos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DiscountPromotionTest {
    @Test
    public void test_promote_should_return_25_when_input_carItem_with_price_100() throws Exception {
        DiscountPromotion discountPromotion = new DiscountPromotion(75);
        CarItem carItem = new CarItem(new Item("ITEM000001", 100), 1);

        double result = discountPromotion.promote(carItem);

        assertThat(result, is(25.0));
    }

}
