package oca_8.flow_control_and_exceptions;

public class FinalTest {

    final int x;
//    final int y;      CE

    public FinalTest(int x, int y) {
        this.x = x;
//        this.y = y;
    }

/*
    if their is final variables they should be init
    in every constructor
*/
    public FinalTest() {
        x = 5;
    }

}


