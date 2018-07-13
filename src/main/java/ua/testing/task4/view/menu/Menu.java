package ua.testing.task4.view.menu;

import ua.testing.task4.view.util.BundleKey;

public enum Menu implements BundleKey{
    QUESTIONNAIRE("questionnaireMenu")
    ,;


    private String key;

    Menu(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
