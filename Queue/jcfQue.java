package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class jcfQue {
    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>(); // ArrayDeque (queue is the interface (oops) we can't create the object's so we used the it's implacemntion ds)
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        Queue<Integer> q = new ArrayDeque<>(); // ArrayDeque (queue is the interface (oops) we can't create the object's so we used the it's implacemntion ds)
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
