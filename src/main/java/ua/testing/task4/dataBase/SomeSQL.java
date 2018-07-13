package ua.testing.task4.dataBase;

import ua.testing.task4.model.entity.questionnaire.Questionnaire;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SomeSQL {
    volatile static Set<Questionnaire> db = new HashSet<>();

    public synchronized static void setData(Questionnaire questionnaire){

        if (questionnaire.getAddDate() == null){
            questionnaire.setAddDate(new Date());
        }
        questionnaire.setUpdateDate(new Date());

        db.add(questionnaire);
    }

    public static Set<Questionnaire> getData(){
        return Collections.unmodifiableSet(db);
    }


}
