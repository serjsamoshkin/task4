package ua.testing.task4.controller;

import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.view.ConsoleView;
import ua.testing.task4.view.Information;
import ua.testing.task4.view.localization.LocManager;
import ua.testing.task4.view.localization.Local;
import ua.testing.task4.view.localization.ResourceManager;
import ua.testing.task4.view.menu.Menu;
import ua.testing.task4.view.util.BundleKey;
import ua.testing.task4.view.util.LocGetter;

public class MainController implements Controller{
    private ConsoleView view;
    private ConsoleInput inputController;

    private ResourceManager interfaceLocManager = LocManager.INTERFACE.getResourceManager();
    private ResourceManager regexResourceManager = LocManager.REGEX.getResourceManager();

    public MainController(ConsoleView view, ConsoleInput inputController) {
        this.view = view;
        this.inputController = inputController;
    }

    public void start(){

        Local loc = getCommandFromEnum(Local.class, Information.GET_LOCALE);
        interfaceLocManager.changeResource(loc.getLocale());
        regexResourceManager.changeResource(loc.getLocale());

        Menu menu = getCommandFromEnum(Menu.class, Information.GREETING);

        switch (menu){
            case QUESTIONNAIRE:
                new QuestionnaireController(view,
                            inputController)
                        .start();
                break;
                default:
                    throw new IllegalArgumentException();
        }

    }

    private<T extends Enum<T> & BundleKey> T getCommandFromEnum(Class<T> clazz, BundleKey quest){

        T[] values = clazz.getEnumConstants();

        StringBuilder qString = new StringBuilder();

        int i = 1;
        for (T val :
                values) {

            qString.append(i).append(" - ").append(LocGetter.getLocString(val)).append('\n');
            i++;
        }

        T command = null;

        while (true){
            view.display(quest, qString.toString());

            String input = inputController.getInput();

            if (input.matches(String.format("\\A[1-%s]\\Z", values.length))){
                command = values[Integer.valueOf(input)-1];
                break;
            }else {
                view.display(Information.FORMAT_INCORRECT);
            }
        }

        return command;

    }

}
