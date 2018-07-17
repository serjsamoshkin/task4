package ua.testing.task4.dataBase;

import ua.testing.task4.model.entity.notebook.Note;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * For tests
 */
public class NoteBookBase {
    volatile static Set<Note> db = new HashSet<>();

    public synchronized static void setData(Note note){

        if (note.getAddDate() == null){
            note.setAddDate(new Date());
        }
        note.setUpdateDate(new Date());

        db.add(note);
    }

    public static Set<Note> getData(){
        return Collections.unmodifiableSet(db);
    }


}
