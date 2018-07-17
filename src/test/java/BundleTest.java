import org.junit.Assert;
import org.junit.Test;
import ua.testing.task4.model.entity.notebook.Note;
import ua.testing.task4.view.annotation.Bundle;
import ua.testing.task4.view.annotation.NoBundleAnnotationException;
import ua.testing.task4.view.localization.LocalizedString;
import ua.testing.task4.view.localization.processor.Locale;
import ua.testing.task4.view.localization.processor.LocaleManager;
import ua.testing.task4.view.localization.processor.ResourceManager;

import java.lang.reflect.Field;
import java.util.MissingResourceException;

public class BundleTest {


    @Test
    public void testCompletenessOfBundle() {

        ResourceManager interfaceManager = LocaleManager.INTERFACE.getResourceManager();
        interfaceManager.changeResource(Locale.DEF.getLocale());

        for (Field field :
                Note.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Bundle.class)) {
                try {
                    LocalizedString.SubType[] subTypes = LocalizedString.SubType.values();
                    for (int i = 0; i < subTypes.length; i++) {
                        LocalizedString.SubType subType = subTypes[i];
                        String str_f = "";
                        try {
                            str_f = LocalizedString.getLocString(field, subType);
                        } catch (MissingResourceException e) {
                            // nothing to do, we have empty str_q and we'll check it next
                        }
                        Assert.assertFalse(
                                String.format("There is no value in Bundle %s with key %s",
                                        LocaleManager.INTERFACE.getResourceName(),
                                        LocalizedString.getBundleKey(field, subType)),
                                str_f.isEmpty()
                        );
                    }

                } catch (NoBundleAnnotationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testRegexBundle() {

        ResourceManager interfaceManager = LocaleManager.REGEX.getResourceManager();
        interfaceManager.changeResource(Locale.DEF.getLocale());

        for (Field field :
                Note.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Bundle.class)) {
                try {
                    String str_f = "";
                    try {
                        str_f = LocalizedString.getRegex(field);
                    } catch (MissingResourceException e) {
                        // nothing to do, we have empty str_q and we'll check it next
                    }
                    Assert.assertFalse(
                            String.format("There is no value in Bundle %s with key %s",
                                    LocaleManager.INTERFACE.getResourceName(),
                                    LocalizedString.getBundleKey(field)),
                            str_f.isEmpty()
                    );

                } catch (NoBundleAnnotationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
