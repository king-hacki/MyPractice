package item_16_accessor_methods_over_fields.forTest;

import item_16_accessor_methods_over_fields.TestProvider;

public class AccessTestes {

    public static void main(String[] args) {

        TestProvider testProvider = new TestProvider();
        TestProvider testProvider1 = new TestProvider();

        System.out.println(testProvider.p);
        System.out.println(testProvider.f);
        System.out.println(testProvider.getM());


    }
}
