package ua.testing.task4.view.output;

import ua.testing.task4.view.enumExtender.BundleKey;

/**
 * Contains variants of main application menu
 */
public enum Menu implements BundleKey{
    NOTEBOOK("notebookMenu"),
    REGISTRATION("registration"),
    ;

    private String key;

    Menu(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
