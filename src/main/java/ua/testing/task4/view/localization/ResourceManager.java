package ua.testing.task4.view.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

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

    public Enumeration getSetKey(){
        return resourceBundle.getKeys();
    }


}
