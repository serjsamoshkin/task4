package ua.testing.task4.view;

import ua.testing.task4.view.util.BundleKey;

/**
 * Contains variants of output to the user
 */
public enum Information implements BundleKey{

    GET_LOCALE("getLocale"),
    GREETING("greeting"),
    GOOD_BYE("goodBuy"),
    FORMAT_INCORRECT("formatIncorrect"),
    ;

    private String key;

    Information(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
