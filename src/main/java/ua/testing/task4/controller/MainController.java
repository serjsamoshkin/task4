package ua.testing.task4.controller;

import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.view.ConsoleView;
import ua.testing.task4.view.output.InformationMessage;
import ua.testing.task4.view.localization.processor.LocaleManager;
import ua.testing.task4.view.localization.processor.Locale;
import ua.testing.task4.view.localization.processor.ResourceManager;
import ua.testing.task4.view.output.Menu;
import ua.testing.task4.view.enumExtender.BundleKey;
import ua.testing.task4.view.localization.LocalizedString;

/**
 * Main controller of the application
 */
public class MainController implements Controller{
    private ConsoleView view;
    private ConsoleInput inputController;

    private ResourceManager interfaceLocManager = LocaleManager.INTERFACE.getResourceManager();
    private ResourceManager regexResourceManager = LocaleManager.REGEX.getResourceManager();

    public MainController(ConsoleView view, ConsoleInput inputController) {
        this.view = view;
        this.inputController = inputController;
    }

    public void start(){

        Locale loc = getCommandFromEnum(Locale.class, InformationMessage.GET_LOCALE);
        interfaceLocManager.changeResource(loc.getLocale());
        regexResourceManager.changeResource(loc.getLocale());

        Menu menu = getCommandFromEnum(Menu.class, InformationMessage.GREETING);

        switch (menu){
            case NOTEBOOK:
                new NotebookController(view,
                            inputController)
                        .start();
                break;
                default:
                    throw new IllegalArgumentException();
        }

    }

    /**
     * Display header messages, loop over EnumConstants of clazz parameter and display localized representation of
     * EnumConstant.
     *
     * @param clazz marker class
     * @param headers {@code BundleKey} subclass
     * @param <T> type of marker class
     * @return EnumConstant selected by the user
     */
    private<T extends Enum<T> & BundleKey> T getCommandFromEnum(Class<T> clazz, BundleKey... headers){

        T[] values = clazz.getEnumConstants();
        T command;

        StringBuilder variants = new StringBuilder();

        int i = 1;
        for (T val : values) {
            variants.append(i).append(" - ").append(LocalizedString.getLocString(val)).append('\n');
            i++;
        }

        while (true){
            for (BundleKey header : headers) {
                view.display(header, variants.toString());
            }

            String input = inputController.getInput();

            if (input.matches(String.format("\\A[1-%s]\\Z", values.length))){
                command = values[Integer.valueOf(input)-1];
                break;
            }else {
                view.display(InformationMessage.FORMAT_INCORRECT);
            }
        }

        return command;

    }

}
