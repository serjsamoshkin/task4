package ua.testing.task4.view.output.authentication;

import ua.testing.task4.view.enumExtender.BundleKey;

/**
 * Contains variants of output to the Registration new user menu
 */
public enum  Registration implements BundleKey {

    GREETING("registration.greeting"),
    USER_NOT_UNIQUE("registration.user_not_unique"),
    ;


    private String key;

    Registration(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
