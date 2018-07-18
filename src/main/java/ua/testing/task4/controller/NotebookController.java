package ua.testing.task4.controller;

import ua.testing.task4.controller.util.Reflect;
import ua.testing.task4.dataBase.NoteBookBase;
import ua.testing.task4.controller.input.ConsoleInput;
import ua.testing.task4.model.entity.notebook.Note;
import ua.testing.task4.view.ConsoleView;

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

        Note note = new Reflect(view, inputController).loopOverFields(Note.class, new Note());
        NoteBookBase.setData(note);

    }



}
