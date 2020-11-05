package dates_strings_localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertiesTest {

    public static void main(String[] args) {

        Locale en = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", en);
        Properties properties = new Properties();

        resourceBundle.keySet()
                .forEach(k -> properties.put(k, resourceBundle.getString(k)));

        System.out.println(properties.getProperty("hello"));
        System.out.println(properties.getProperty("open"));

        System.out.println(properties.getProperty("notExist"));
        System.out.println(properties.getProperty("notExist", "notExistKey"));

    }

}
