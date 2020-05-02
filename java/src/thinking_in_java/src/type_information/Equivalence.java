package type_information;

public class Equivalence {


    private static void testBase(Object x) {

        System.out.println(x.getClass());                                   //  base
        System.out.println(x instanceof Base);                              //  true
        System.out.println(x instanceof Derived);                           //  false

        System.out.println(Base.class.isInstance(x));                       //  true
        System.out.println(Derived.class.isInstance(x));                    //  true

        System.out.println(x.getClass().isInstance(Base.class));            //  false
        System.out.println(x.getClass().isInstance(Derived.class));         //  false

        System.out.println(x.getClass() == Base.class);                     //  true
        System.out.println(x.getClass() == Derived.class);                  //  false

        System.out.println(x.getClass().equals(Base.class));                //  true
        System.out.println(x.getClass().equals(Derived.class));             //  false


    }

    private static void testDerived(Object x) {

        System.out.println(x.getClass());                                   //  derived
        System.out.println(x instanceof Base);                              //  true
        System.out.println(x instanceof Derived);                           //  true

        System.out.println(Base.class.isInstance(x));                       //  true
        System.out.println(Derived.class.isInstance(x));                    //  true

        System.out.println(x.getClass().isInstance(Base.class));            //  false
        System.out.println(x.getClass().isInstance(Derived.class));         //  false

        System.out.println(x.getClass() == Base.class);                     //  false
        System.out.println(x.getClass() == Derived.class);                  //  true

        System.out.println(x.getClass().equals(Base.class));                //  false
        System.out.println(x.getClass().equals(Derived.class));             //  true


    }

    public static void main(String[] args) {
        testBase(new Base());
        testDerived(new Derived());
    }
}

class Base {}
class Derived extends Base {}