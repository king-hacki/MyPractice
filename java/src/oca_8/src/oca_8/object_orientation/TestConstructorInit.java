package oca_8.object_orientation;

public class TestConstructorInit {

    public static void main(String[] args) {

    }

}

class Dad {
    static final int DEFAULT = 0;
    int x;
    public Dad(int x) {
        this.x = x;
    }
}

class Son extends Dad {
    static int x;
    int y;
    Son(int i) {
        super(i);
//        super(x);             OK
//        super(y);             CE
//        super(Dad.DEFAULT);   OK

    }


//    Son() {       CE recursively constructor invocation
//        this();
//    }

//    Son() {
//        super();
//        this();   CE this() and super() must go exactly after constructor so I can't write super() and this()
//    }
}
