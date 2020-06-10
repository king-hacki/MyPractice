package oca_8.different_tests.Boyarskyi;

public class StaticRopeSwing {

    public static final String s1;
    public static final String s2;
//    public static final String s3;            CE
    public static final String s4 = "s4";

    static {
        s1 = "s1";
        s2 = "s2";
    }

    static {
//        s4 = "s4";                CE
//        s2 = "s2";                CE
    }

    public static void main(String[] args) {
//        s3 = "f";                 CE
    }

}
