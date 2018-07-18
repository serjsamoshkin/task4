package ua.testing.task4.view.localization;

import ua.testing.task4.view.annotation.Bundle;
import ua.testing.task4.view.annotation.NoBundleAnnotationException;
import ua.testing.task4.view.enumExtender.BundleKey;
import ua.testing.task4.view.localization.processor.LocaleManager;
import ua.testing.task4.view.localization.processor.ResourceManager;

import java.lang.reflect.Field;

/**
 * Class contains static methods to obtain a localized string from ResourceManager (bundle) with:
 *  key from getKey() method of BundleKey interface implementing objects.
 *  key value from annotated with @Bundle fields
 */
public class LocalizedString {

    private static final ResourceManager interfaceManager = LocaleManager.INTERFACE.getResourceManager();
    private static final ResourceManager regexManager = LocaleManager.REGEX.getResourceManager();

    /**
     * Return localized string with key from {@code obj} that implements BundleKey interface
     * @param obj instance of class that is implemented BundleKey interface
     * @return localized string from bundle
     */
    public static String getLocString(BundleKey obj){
        return interfaceManager.getString(obj.getKey());
    }

    /**
     * Return localized string with key from {@code obj} that implements BundleKey interface
     * @param obj instance of class that is implemented BundleKey interface
     * @return localized string from bundle
     */
    public static String getRegex(BundleKey obj){
        return regexManager.getString(obj.getKey());
    }

    /**
     * Return localized string with key from field annotation @Bundle and subType enum value.
     * Is used to obtain variable strings from one key, for example Field (variable) of entity.
     * @param field annotated with @Bundle annotation
     * @param subType adds additional variants to a single key
     * @return localized string from bundle
     * @throws NoBundleAnnotationException
     */
    public static String getLocString(Field field, SubType subType) throws NoBundleAnnotationException {
        return interfaceManager.getString(getBundleKey(field, subType));
    }

    /**
     * Return localized regex string with key from field annotation @Bundle
     * @param field annotated with @Bundle annotation
     * @return regex pattern from bundle
     * @throws NoBundleAnnotationException
     */
    public static String getRegex(Field field) throws NoBundleAnnotationException{
        if (field.isAnnotationPresent(Bundle.class)) {
            String bundleKey = field.getAnnotation(Bundle.class).key();
            return regexManager.getString(bundleKey);
        }else {
            throw new NoBundleAnnotationException();
        }
    }

    /**
     * Return localized string with key
     * @param str bundle key
     * @return
     */
    public static String getLocString(String str){
        return interfaceManager.getString(str);
    }

    /**
     * Return localized regex string with key
     * @param str bundle key
     * @return
     */
    public static String getRegex(String str){
        return regexManager.getString(str);
    }

    /**
     * Creates {@code String} key from field @Bundle annotation value and value of concrete EnumConstant of SubType.
     * Used "." to delimiter values
     *
     * @param field annotated with @Bundle annotation
     * @param subType adds additional variants to a single key
     * @return
     * @throws NoBundleAnnotationException
     */
    public static String getBundleKey(Field field, SubType subType)  throws NoBundleAnnotationException{
        return getBundleKey(field) + "." + subType.getValue();
    }

    /**
     * Creates {@code String} key from field @Bundle annotation value.
     *
     * @param field annotated with @Bundle annotation
     * @return
     * @throws NoBundleAnnotationException
     */
    public static String getBundleKey(Field field)  throws NoBundleAnnotationException{
        if (field.isAnnotationPresent(Bundle.class)) {
            String bundleKey = field.getAnnotation(Bundle.class).key();
            return bundleKey;
        }else {
            throw new NoBundleAnnotationException();
        }
    }

    /**
     * Adds additional variants to a key representation in bundle,
     * for example field.name.question == "Enter the name:"
     * and field.id.representation == "Name:". Used to represent entity or
     * print columns in entity table
     */
    public enum SubType{
        QUESTION("question"),
        REPRESENTATION("representation"),
        INCORRECT("incorrect"),
        ;

        String value;

        SubType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
