package com.jason.pos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PosSystemTest {
    @Test
    public void test_read_item_file_should_return_item_list_when_input_file_path()throws Exception {
        String itemListFile = this.getClass().getClassLoader().getResource("itemlist.txt").getPath();
        PosSystem posSystem = new PosSystem();

        assertThat( posSystem.readItemFile(itemListFile).size(),is(3));
    }

    @Test
    public void test_read_second_half_price_promotion_should_add_promotion_to_list_when_input_file_path(){
//        String itemListFile = this.getClass().getClassLoader().getResource("itemlist.txt").getPath();
//        String promotionItemListFile  = this.getClass().getClassLoader().getResource("second_half_price_promotion.txt").getPath();
//        PosSystem posSystem = new PosSystem();
//        posSystem.setItems(posSystem.readItemFile(itemListFile));
//
//        List<Item> result = posSystem.readSecondHalfPricePromotionFile(promotionItemListFile);
//
//        assertThat(result.get(0).getPromotion(),is());
    }

}
