package type_information;

import java.util.Random;

public class EckelInterestingClassInit {

    public static Random random = new Random(47);

    public static void main(String[] args) {
        Class<Initable> init = Initable.class;
        System.out.println("After Initable.class");
        System.out.println(Initable.staticFinal);   //  doesnt init Initiable  (don't call static block)
        System.out.println(Initable.staticFinal2);  //  init Initiable  (call static block)

    }

}

class Initable {

    final static String staticFinal = "HI";
    final static int staticFinal2 = EckelInterestingClassInit.random.nextInt(1000);
    static {
        System.out.println("Initable inited");
    }

}





