package oca_8.different_tests.Boyarskyi;

public class TestReturnFloatingPointToNumber {

    int methodInt() {
//        return 1.2f;      CE
        return 5;
    }

    long methodLong() {
//        return 1.2;       CE
        return 3;
    }

    float methodFloat() {
//        return 2.3;       CE returned double
        return 2.3f;
    }

    double methodDouble() {
        return 3.3;
    }

    public static void main(String[] args) {

    }

}


