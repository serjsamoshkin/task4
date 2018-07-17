package ua.testing.task4.view.localization.processor;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

/**
 * Enum constant return a unique ResourceManager instance for each thread
 */
public enum LocaleManager {

    INTERFACE("interface"),
    REGEX("regex"),
    ;

    private String resourceName;
    // For example we can use Session instead of Thread, so we can call this variable sessionResourceManagerMap
    private static WeakHashMap<Thread, Map<LocaleManager, ResourceManager>> threadResourceManagerMap = new WeakHashMap<>();
    private static ThreadLocal<Map<LocaleManager, ResourceManager>> threadLocalResourceManager = new  ThreadLocal<>();
    //private ResourceManager manager;

    LocaleManager(String resourceName){
        this.resourceName = resourceName;
        //this.manager = new ResourceManager(resourceName);
    }

    /**
     * Returns resourceName String for Enum constant
     * @return
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Returns {@code ResourceManager} for Enum constant unique for each thread and resourceName
     * @return {@code ResourceManager} - class wrapper of ResourceBundle
     */
    public ResourceManager getResourceManager(){

        ResourceManager manager;
        Map<LocaleManager, ResourceManager> map;

        /*
        Since ThreadLocal uses ThreadLocalMap, access operations can be faster in one thread.
        WeakHashMap is needed to store ResourceManager with another unique delimiter (different from the thread),
        for example Session, as if there is a "SessionLocal"
         */
        // TODO кажется я перемудрил... как минимум вынести работу с map в отдельные процедуру...
        if (threadLocalResourceManager.get() == null){
            if (threadResourceManagerMap.containsKey(Thread.currentThread())){
                //
                map = threadLocalResourceManager.get();
                if (map.containsKey(this)){
                    manager = map.get(this);
                }else {
                    manager = new ResourceManager(resourceName);
                    map.put(this, manager);
                }
                threadLocalResourceManager.set(map);
                //
            }else {
                map = new HashMap<>();
                manager = new ResourceManager(resourceName);
                map.put(this, manager);
                threadResourceManagerMap.put(Thread.currentThread(), map);
            }
            threadLocalResourceManager.set(map);
        }else {
            map = threadLocalResourceManager.get();
            if (map.containsKey(this)){
                manager = map.get(this);
            }else {
                manager = new ResourceManager(resourceName);
                map.put(this, manager);
            }
            threadLocalResourceManager.set(map);
        }

        return manager;
    }

}
