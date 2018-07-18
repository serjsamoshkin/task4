package ua.testing.task4.view;

import ua.testing.task4.view.annotation.NoBundleAnnotationException;
import ua.testing.task4.view.enumExtender.BundleKey;
import ua.testing.task4.view.localization.LocalizedString;
import ua.testing.task4.view.util.ConsoleOutputColor;

import java.lang.reflect.Field;

/**
 *  Contains output methods to interact with the user.
 *  Used console for output.
 */
public class ConsoleView {

    public void display(BundleKey obj){
        display(LocalizedString.getLocString(obj));
    }

    public void display(BundleKey obj, String... params){
        display(String.format(LocalizedString.getLocString(obj), params));
    }

    public void display(BundleKey obj, ConsoleOutputColor color){
        display(LocalizedString.getLocString(obj), color);
    }

    public void display(BundleKey obj, ConsoleOutputColor color, String... params){
        display(String.format(LocalizedString.getLocString(obj), params), color);
    }

    public void display(Field field, LocalizedString.SubType subType) throws NoBundleAnnotationException{
        display(LocalizedString.getLocString(field, subType));
    }



    private void display(String message, ConsoleOutputColor color, String... params){
        display(color + String.format(message, params));
    }

    private void display(String message, ConsoleOutputColor color){
        display(color + message);
    }

    private void display(String message, String... params){
        display(String.format(message, params));
    }


    private void display(String message){
        System.out.println(message + ConsoleOutputColor.ANSI_WHITE);
    }

}
