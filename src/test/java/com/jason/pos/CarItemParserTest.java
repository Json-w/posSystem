package com.jason.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CarItemParserTest {

    @Test
    public void test_parse_should_return_carItem_list_when_input_string_list(){
        List<String> input = new ArrayList<String>();
        input.add("ITEM000001-3");
        input.add("ITEM000003-2");
        input.add("ITEM000005-2");
        CarItemParser carItemParser = new CarItemParser();

        List<CarItem> result =  carItemParser.parse(input);

        assertThat(result.size(),is(3));
        assertThat(result.get(0).getItem().getCode(),is("ITEM000001"));
        assertThat(result.get(0).getAmount(),is(3));
    }
}
