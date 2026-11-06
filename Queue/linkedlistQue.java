package Queue;

import java.util.LinkedList;

public class linkedlistQue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
     }
    static class Queuu {
        

        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null; 
        }


        // add
        public static void add(int data){
            Node newNode = new Node(data);

            // if we addeding the first element then we need to update the front also 
            if( head ==  null) {
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public static int remove () {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;
            if(head == tail) {
                head = tail = null;
            }else{
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            // return arr[0]; //here our peek is front 
            return head.data;
        }
    } 
    public static void main(String[] args) {
        Queuu q = new Queuu();
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
