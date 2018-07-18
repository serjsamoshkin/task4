package ua.testing.task4.dataBase.util;

import ua.testing.task4.dataBase.UsersBase;
import ua.testing.task4.model.entity.authentication.UserIsNotUnique;
import ua.testing.task4.model.entity.authentication.User;

public class DbInitializer {

    public void setUserDbDemoData(UsersBase userDb){

        User user= new User();
        user.setUserName("Иванов");
        user.setPassword("123456");

        try {
            userDb.setData(user);
        }catch (UserIsNotUnique e){
            e.printStackTrace();
        }

        User user1 = new User();
        user1.setUserName("Петров");
        user1.setPassword("123456");

        try {
            userDb.setData(user1);
        }catch (UserIsNotUnique e){
            e.printStackTrace();
        }

        User user2 = new User();
        user2.setUserName("Сидоров");
        user2.setPassword("123456");

        try {
            userDb.setData(user2);
        }catch (UserIsNotUnique e){
            e.printStackTrace();
        }



    }

}
