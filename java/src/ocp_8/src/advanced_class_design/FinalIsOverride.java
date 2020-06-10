package advanced_class_design;

public class FinalIsOverride {
    public static void main(String[] args) {

    }
}

class FinalTest1 {
    void dis() {
        System.out.println("FinalTest1");
    }
}

class FinalTest2 extends FinalTest1 {

    @Override
    final strictfp void dis() {
        System.out.println("FinalTest2");
    }
}
