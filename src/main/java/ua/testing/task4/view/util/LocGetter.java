package ua.testing.task4.view.util;

import ua.testing.task4.view.localization.LocManager;
import ua.testing.task4.view.localization.ResourceManager;

public class LocGetter {

    private static final ResourceManager manager = LocManager.INTERFACE.getResourceManager();
    private static final ResourceManager regex = LocManager.REGEX.getResourceManager();


    public static String getLocString(BundleKey obj){
        return manager.getString(obj.getKey());
    }

    public static String getLocString(String str){
        return manager.getString(str);
    }

    public static String getRegex(BundleKey obj){
        return regex.getString(obj.getKey());
    }

    public static String getRegex(String str){
        return regex.getString(str);
    }

}
