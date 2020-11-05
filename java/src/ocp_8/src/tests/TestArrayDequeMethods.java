package tests;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestArrayDequeMethods {
    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(18);          //  boolean back throw exception if can't add
        queue.offer(5);     //  boolean back return false if can't add
        queue.push(13);      //  void front

        System.out.println(queue);
        System.out.println("Task : " + queue.poll() + " " + queue.poll());

        System.out.println("peek : " + queue.peek());       //  return null if queue empty
        System.out.println("element : " + queue.element());    //  throw exception if queue empty
        System.out.println("peekFirst : " + queue.peekFirst());
        System.out.println("peekLast : " + queue.peekLast());

        queue.push(4);
        System.out.println(queue);

        System.out.println("pop : " + queue.pop());             //  throw exc
        System.out.println("poll : " + queue.poll());           //  null
        System.out.println("remove : " + queue.remove());       //  throw exc

        System.out.println(queue);

    }
}
