package ua.testing.task4.view.output;

import ua.testing.task4.view.enumExtender.BundleKey;

/**
 * Contains variants of output to the user
 */
public enum InformationMessage implements BundleKey{

    GET_LOCALE("getLocale"),
    GREETING("greeting"),
    GOOD_BYE("goodBuy"),
    FORMAT_INCORRECT("formatIncorrect"),
    ;

    private String key;

    InformationMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
