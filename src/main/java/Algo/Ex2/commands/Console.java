package Algo.Ex2.commands;

import java.util.Scanner;

public class Console {

    Scanner in = new Scanner(System.in);

    public int inputInt(String text) {

        System.out.println(text);
        String input = in.nextLine();

        try {
            
            return Integer.parseInt(input);
        } catch ( NumberFormatException ex ) {

            return inputInt("Please Insert a number");
        }
    }

    public String inpuString(String text) {

        System.out.println(text);
        return in.nextLine();
    }
}