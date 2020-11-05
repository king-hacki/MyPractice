package dates_strings_localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main(String[] args) {

        Locale us = new Locale("en", "US");
        Locale fr = new Locale("fr", "FR");

        printProperties(fr);
        printProperties(us);

    }

    private static void printProperties(Locale local) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", local);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("open"));
    }

}
