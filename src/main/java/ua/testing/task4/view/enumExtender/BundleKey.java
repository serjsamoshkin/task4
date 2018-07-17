package ua.testing.task4.view.enumExtender;

/**
 * Interface is served to extend Enum types and declares the method for overriding in Enum.
 * Instances that implement BundleKey interface is used as parameter in display() method of ConsoleView class
 * @see ua.testing.task4.view.localization.LocalizedString
 * @see ua.testing.task4.view.ConsoleView
 */
public interface BundleKey {

    public String getKey();

}
