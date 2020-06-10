package oca_8.different_tests.real_oca_test;

public class ModificationInHierarchyTest_2 {

}

abstract class Planet {
    protected void revolve() {}
    abstract void rotate();
}

class Earth extends Planet {
//    void revolve() {}
    void rotate() {}
}
