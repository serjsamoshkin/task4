package ua.testing.task4;

import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.controller.MainController;
import ua.testing.task4.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        new MainController(
                new ConsoleView(),
                new ConsoleInput()
        ).start();

    }

}

