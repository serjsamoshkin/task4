package ua.testing.task4.controller.input;

import java.util.Scanner;

/**
 * Uses to get input commands from console
 */
public class ConsoleInput {

    private final Scanner sc = new Scanner(System.in);

    public String getInput(){
        return sc.nextLine();
    }

}
