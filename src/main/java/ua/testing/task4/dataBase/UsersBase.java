package ua.testing.task4.dataBase;

import ua.testing.task4.model.entity.authentication.UserIsNotUnique;
import ua.testing.task4.model.entity.authentication.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UsersBase {

    volatile Set<User> db = new HashSet<>();

    public UsersBase() {
        // init demo data
    }

    public synchronized void setData(User user) throws UserIsNotUnique {

        if (db.contains(user)){
            throw new UserIsNotUnique(user.getUserName());
        }

        db.add(user);
    }

    public Set<User> getData(){
        return Collections.unmodifiableSet(db);
    }



}
