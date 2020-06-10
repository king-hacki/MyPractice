package oca_8.flow_control_and_exceptions;

public class LabelTes {

    public static void main(String[] args) {
        f:
            for (; true; )
            foo:
                while (true) {
//                  break test;         CE test is unreachable
                    break f;
//                  break foo;    CE break foo is unreachable
            }
        test:
            System.out.println();

        int x = 1;
        clauseTest:
        {
            x++;
        }
        System.out.println(x);  //  print 2
    }

}
