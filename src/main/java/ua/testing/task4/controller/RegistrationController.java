package ua.testing.task4.controller;

import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.controller.util.Reflect;
import ua.testing.task4.dataBase.UsersBase;
import ua.testing.task4.dataBase.util.DbInitializer;
import ua.testing.task4.model.entity.authentication.UserIsNotUnique;
import ua.testing.task4.model.entity.authentication.User;
import ua.testing.task4.view.ConsoleView;
import ua.testing.task4.view.output.authentication.Registration;
import ua.testing.task4.view.util.ConsoleOutputColor;

public class RegistrationController implements Controller {

    private ConsoleView view;
    private ConsoleInput inputController;


    public RegistrationController(ConsoleView view, ConsoleInput inputController) {
        this.view = view;
        this.inputController = inputController;
    }

    @Override
    public void start() {

        UsersBase usersBase = new UsersBase();

        new DbInitializer().setUserDbDemoData(usersBase);

        while (true){

            view.display(Registration.GREETING);

            User user = new Reflect(view, inputController).loopOverFields(User.class, new User());

            try {
                usersBase.setData(user);
                break;
            }catch (UserIsNotUnique e){
                view.display(Registration.USER_NOT_UNIQUE,
                        ConsoleOutputColor.ANSI_RED,
                        e.getKeyName());
            }

        }
    }
}
