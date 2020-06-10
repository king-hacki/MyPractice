package advanced_class_design;

import org.w3c.dom.ls.LSOutput;

public class TestEffectivelyFinalWithLocalClass {

    int x;

    void test() {
        int x = TestEffectivelyFinalWithLocalClass.this.x;
        class Inner {
            int x = TestEffectivelyFinalWithLocalClass.this.x;
            void display() {
                System.out.println(x);
            }
        }
//        x = 5;
    }

    public static void main(String[] args) {
        if (null instanceof Object)
            System.out.println("hi");
    }

    @Override
    public int hashCode() {
        return x;
    }
}


