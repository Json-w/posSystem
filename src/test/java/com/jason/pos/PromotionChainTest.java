package com.jason.pos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PromotionChainTest {
    @Test
    public void test_promote_should_return_save_money_after_multi_promotion_when_input_item_can_promoted_by_multi_promotion() throws Exception {
        PromotionChain promotionChain = new PromotionChain();
        promotionChain.addPromotion(new DiscountPromotion(50));
        promotionChain.addPromotion(new SecondHalfPromotion());
        CarItem carItem = new CarItem(new Item("ITEM000001", 100), 2);

        double result = promotionChain.promote(carItem);

        assertThat(result,is(125.0));
    }
}
