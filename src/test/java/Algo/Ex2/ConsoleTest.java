package Algo.Ex2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class ConsoleTest {
    
    @Test
    public void inputInt() {

        String input = "abcdefg";

        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
    }
}