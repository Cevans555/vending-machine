package com.techelevator;

import java.util.Scanner;

public class ScannerInput {

    public static String userInput(){
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        return input;
    }

}
