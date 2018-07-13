package ua.testing.task4.view.localization;

import ua.testing.task4.view.util.BundleKey;

import java.util.Locale;

public enum Local implements BundleKey{
    DEF("def_loc", Locale.getDefault()),
    EN("en_loc", new Locale("en", "EN")),
    UA("ua_loc", new Locale("ua", "UA")),
    ;

    private String key;
    private Locale locale;

    Local(String name, Locale locale) {
        this.key = name;
        this.locale = locale;
    }

    public String getKey() {
        return key;
    }

    public Locale getLocale() {
        return locale;
    }
}
