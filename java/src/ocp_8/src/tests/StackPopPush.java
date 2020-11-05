package tests;

import java.util.ArrayDeque;
import java.util.Deque;

//  push peek pop
public class StackPopPush {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(5);
        stack.push(6);
        System.out.println(stack);
    }

}
