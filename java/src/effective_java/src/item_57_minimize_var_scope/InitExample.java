package item_57_minimize_var_scope;

public class InitExample {

    int x = 0;  //  BAD PREMATURELY INIT

    void exampleMethod() {

        System.out.println(x);

        int y = 0;      //  GOOD INIT EXACTLY WHEN NEED
        System.out.println(y);
    }

}
