package ua.testing.task4.controller;

import ua.testing.task4.dataBase.SomeSQL;
import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.model.annotation.Bundle;
import ua.testing.task4.model.annotation.Ref;
import ua.testing.task4.model.entity.questionnaire.Questionnaire;
import ua.testing.task4.view.ConsoleView;
import ua.testing.task4.view.util.LocGetter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QuestionnaireController implements Controller{
    private ConsoleView view;
    private ConsoleInput inputController;


    public QuestionnaireController(ConsoleView view, ConsoleInput inputController) {
        this.view = view;
        this.inputController = inputController;
    }

    public void start() {


        Questionnaire questionnaire = new Questionnaire();
        loopOverFields(Questionnaire.class, questionnaire);

        SomeSQL.setData(questionnaire);

        System.out.println(SomeSQL.getData());


    }

    private<T> void loopOverFields(Class<T> clazz, T obj){
        Field[] fields = clazz.getDeclaredFields();




//        for (int i = 0; i < fields.length; i++) {
        for (int i = 0; i < 5; i++) {// дальше не написал логику:)

            Field field = fields[i];
            if (field.isAnnotationPresent(Bundle.class)){
                if (field.isAnnotationPresent(Ref.class)){
                    // TODO сделать через конструктор без аргументов, получить сеттер
//                    loopOverFields(field.getAnnotation(Ref.class).clazz());
                }else {
                    String bundleName = field.getAnnotation(Bundle.class).name();
                    String str = LocGetter.getLocString(bundleName);
                    String regex = LocGetter.getRegex(bundleName);
                    while (true){
                        view.display(str);

                        String input = inputController.getInput();
                        if (input.matches(regex)){
                            try {
                                Method method = getSetterMethodByFieald(obj.getClass(), field);
                                method.invoke(obj,
                                        input);
                                break;
                            }
                            catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e){
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Method getSetterMethodByFieald(Class<?> clazz, Field field) throws NoSuchMethodException {

        StringBuilder str = new StringBuilder(field.getName());
        str.replace(0, 1, Character.toString(str.charAt(0)).toUpperCase());
        str.insert(0, "set");

        return clazz.getMethod(str.toString(), field.getType());

    }

}
