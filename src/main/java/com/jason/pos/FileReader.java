package com.jason.pos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private BufferedReader bufferedReader;

    public List<String> read(String fileName) {
        List<String> result = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            result = new ArrayList<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
