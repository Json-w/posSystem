package com.jason.pos;

import com.jason.pos.common.FileReader;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileReaderTest {
    @Test
    public void test_read_should_return_list_strings_when_input_file_name() throws Exception {
        String fileName = this.getClass().getClassLoader().getResource("itemlist.txt").getPath();
        FileReader fileReader = new FileReader();

        List<String> result = fileReader.read(fileName);

        assertThat(result.size(), is(3));
    }
}
