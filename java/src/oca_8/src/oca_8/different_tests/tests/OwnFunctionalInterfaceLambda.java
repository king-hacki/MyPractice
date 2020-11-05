package oca_8.different_tests.tests;

public class OwnFunctionalInterfaceLambda {

    static void testFunc(FuncInterface funcInterface) {
        funcInterface.display();
    }

    public static final void main(String[] args) {

        testFunc(() -> System.out.println("HI"));

//        AddFuncInterface addFuncInterface = (int x) -> 5 + 4;     can't be int must be long
        AddFuncInterface addFuncInterface = x -> (int) x + 4;
        System.out.println(addFuncInterface.add(100000));
    }
}



@FunctionalInterface
interface FuncInterface {
    void display();
}

@FunctionalInterface
interface AddFuncInterface {
    int add(long x);
}
