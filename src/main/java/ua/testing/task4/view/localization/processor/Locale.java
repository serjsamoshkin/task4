package ua.testing.task4.view.localization.processor;

import ua.testing.task4.view.enumExtender.BundleKey;

public enum Locale implements BundleKey{
    DEF("def_loc", java.util.Locale.getDefault()),
    EN("en_loc", new java.util.Locale("en", "EN")),
    UA("ua_loc", new java.util.Locale("ua", "UA")),
    ;

    private String key;
    private java.util.Locale locale;

    Locale(String name, java.util.Locale locale) {
        this.key = name;
        this.locale = locale;
    }

    public String getKey() {
        return key;
    }

    public java.util.Locale getLocale() {
        return locale;
    }
}
