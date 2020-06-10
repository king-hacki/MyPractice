package oca_8.different_tests.tests;

public class FinalIntToByteWithoutExCast {
    public static void main(String[] args) {
        TestThis testThis = new TestThis(4);
    }
}

class TestThis {

    final int x = 5;
    byte b = x;

    final int y;
//    byte b2 = y;    //  CE

    TestThis(int y) {
        this.y = y;
    }
}