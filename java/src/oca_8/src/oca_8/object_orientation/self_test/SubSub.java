package oca_8.object_orientation.self_test;

class Alpha {
    static String s = "";
    protected Alpha() {
        s += "alpha ";
    }
}

class Sub extends Alpha {
    private Sub() {
        s += "sub ";
    }
}

public class SubSub extends Alpha {

    private SubSub() {
         s += "subsub";
    }

    public static void main(String[] args) {
        new SubSub();
        System.out.println(s);
    }

}
