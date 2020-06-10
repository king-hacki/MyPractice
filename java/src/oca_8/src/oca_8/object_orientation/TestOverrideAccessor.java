package oca_8.object_orientation;

public class TestOverrideAccessor {

    public static void main(String[] args) throws ReflectiveOperationException {
        Base b = new Base();
        Base d = new Derived();

        b.method();
        d.method();
    }
}

class Base {
    void method() throws ReflectiveOperationException {
        System.out.println("base");
    }
}

class Derived extends Base {


//    private void method() {               CE can't be private because in Base is public
//        System.out.println("derived");
//    }

    @Override
    public  void method() {
        System.out.println("derived");
    }
}
