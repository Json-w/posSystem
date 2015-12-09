package com.jason.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPromotionTest {
    @Test
    public void test_promote_should_return_pay_price_when_input_2_second_half_promotion_item() throws Exception {
        SecondHalfPromotion secondHalfPromotion = new SecondHalfPromotion();
        List<CarItem> secondHalfPromotionItems = new ArrayList<CarItem>();
        secondHalfPromotionItems.add(new CarItem(new Item("ITEM000001", 40), 2));

        double payPrice = secondHalfPromotion.promote(secondHalfPromotionItems);

        assertThat(payPrice,is(60.0));
    }
}
