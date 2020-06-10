package oca_8.flow_control_and_exceptions;

public class HierarchyException {
}

class Dad {
    void doStuff() {}
}
class Son extends Dad {
    @Override
    void doStuff() throws RuntimeException {
        super.doStuff();
    }
}