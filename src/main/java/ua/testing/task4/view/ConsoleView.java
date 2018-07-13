package ua.testing.task4.view;

import ua.testing.task4.view.localization.LocManager;
import ua.testing.task4.view.localization.ResourceManager;
import ua.testing.task4.view.util.BundleKey;
import ua.testing.task4.view.util.LocGetter;

/**
 *  Contains output methods to interact with the user.
 *  Uses console for output.
 */
public class ConsoleView {



    public void display(BundleKey obj){
        display(LocGetter.getLocString(obj));
    }

    public void display(BundleKey obj, String... params){
        display(String.format(LocGetter.getLocString(obj), params));
    }

    public void display(BundleKey obj, ConsolOutputColor color){
        display(LocGetter.getLocString(obj), color);
    }

    public void display(BundleKey obj, ConsolOutputColor color, String... params){
        display(String.format(LocGetter.getLocString(obj), params), color);
    }



    public void display(String message, ConsolOutputColor color, String... params){
        display(color + String.format(message, params));
    }

    public void display(String message, ConsolOutputColor color){
        display(color + message);
    }

    public void display(String message, String... params){
        display(String.format(message, params));
    }


    public void display(String message){
        System.out.println( message);
    }

}
