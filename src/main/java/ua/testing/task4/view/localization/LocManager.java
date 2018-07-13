package ua.testing.task4.view.localization;

import java.lang.reflect.Constructor;

public enum LocManager {

    INTERFACE(ResourceManager.class, "interface"),
    REGEX(ResourceManager.class, "regex"),
    ;

    private String resourceName;
    private ResourceManager manager;

    private LocManager(Class<?> clazz, String resourceName){

        try {
            Constructor<?> ctor = clazz.getConstructor(String.class);
            Object object = ctor.newInstance(resourceName);
            this.manager = (ResourceManager)object;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        this.resourceName = resourceName;

    }

    public ResourceManager getResourceManager(){
        return manager;
    }

}
