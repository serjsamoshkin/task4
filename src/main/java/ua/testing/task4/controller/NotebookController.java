package ua.testing.task4.controller;

import ua.testing.task4.dataBase.NoteBookBase;
import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.view.annotation.Bundle;
import ua.testing.task4.view.annotation.NoBundleAnnotationException;
import ua.testing.task4.view.annotation.Ref;
import ua.testing.task4.model.entity.notebook.Note;
import ua.testing.task4.view.ConsoleView;
import ua.testing.task4.view.localization.LocalizedString;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Process the logic of creating a new entity {code@ Note} and adding it to the database {code@ NoteBookBase}
 */
public class NotebookController implements Controller{
    private ConsoleView view;
    private ConsoleInput inputController;


    public NotebookController(ConsoleView view, ConsoleInput inputController) {
        this.view = view;
        this.inputController = inputController;
    }

    public void start() {

        Note note = loopOverFields(Note.class, new Note());

        NoteBookBase.setData(note);

    }

    /**
     * Recursive method. Loop over all fields of the given T obj and over all fields
     * of variable annotated with @Ref.
     * Creates new objects for @Ref annotated fields of {@code Class<T>} using reflection.
     * Sends to view {@code field} annotated with @Bundle to show the localized message to the user,
     * get users input and put it in the current field using reflection
     *
     * @param clazz marker class parameter
     * @param obj the concrete type T object
     * @param <T> generic type of marker class parameter
     */
    private<T> T loopOverFields(Class<T> clazz, T obj){
        Field[] fields = clazz.getDeclaredFields();

//        for (int i = 0; i < fields.length; i++) {
        for (int i = 0; i < 5; i++) {// дальше не написал логику:)

            Field field = fields[i];
            if (field.isAnnotationPresent(Bundle.class)){
                if (field.isAnnotationPresent(Ref.class)){
                    // TODO сделать через конструктор без аргументов, получить сеттер
//                    loopOverFields(field.getAnnotation(Ref.class).clazz());
                }else {
                    String regex;
                    try{
                        regex = LocalizedString.getRegex(field);
                    }catch (NoBundleAnnotationException e){
                        throw new RuntimeException(e);
                    }

                    while (true){
                        try{
                            view.display(field, LocalizedString.SubType.QUESTION);
                        }catch (NoBundleAnnotationException e){
                            throw new RuntimeException(e);
                        }
                        String input = inputController.getInput();
                        if (input.matches(regex)){
                            try {
                                Method method = getSetterMethodByField(obj.getClass(), field);
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
        return obj;
    }

    /**
     * Get no arg {@code Method} using reflection. The method name is created with "set" plus name of the input
     * parameter {@code field}
     * @param clazz Class instance that contains input {@code field}
     * @param field if the field is from another class method will throw an NoSuchMethodException
     * @return {@code Method}
     * @throws NoSuchMethodException
     */
    private static Method getSetterMethodByField(Class<?> clazz, Field field) throws NoSuchMethodException {

        StringBuilder str = new StringBuilder(field.getName());
        str.replace(0, 1, Character.toString(str.charAt(0)).toUpperCase());
        str.insert(0, "set");

        return clazz.getMethod(str.toString(), field.getType());

    }

}
