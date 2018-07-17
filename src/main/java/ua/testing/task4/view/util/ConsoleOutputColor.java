package ua.testing.task4.view.util;

/**
 * Contains console output color cods.
 */
public enum ConsoleOutputColor {
    ANSI_RESET("\u001B[0m")
            {
                boolean someMethod(int i) {
                    return false;
                }
            },
        ANSI_BLACK("\u001B[30m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_RED("\u001B[31m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_GREEN("\u001B[32m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_YELLOW("\u001B[33m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_BLUE("\u001B[34m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_PURPLE("\u001B[35m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_CYAN("\u001B[36m") {
            boolean someMethod(int i) {
                return false;
            }
        },
        ANSI_WHITE("\u001B[37m") {
            boolean someMethod(int i) {
                return false;
            }
        };

private String color;

        ConsoleOutputColor(String color){
        this.color=color;
        }

@Override
public String toString(){
        return this.color;
        }

abstract boolean someMethod(int i);
        }
