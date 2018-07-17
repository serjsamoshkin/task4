package ua.testing.task4.view.localization.processor;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class wrapper of ResourceBundle class
 */
public class ResourceManager {

    private ResourceBundle resourceBundle;
    private String resourceName;


    public ResourceManager(String resourceName){
        this.resourceName = resourceName;
        resourceBundle = ResourceBundle.getBundle(this.resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }


}
