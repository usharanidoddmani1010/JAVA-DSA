package Stack;

import java.util.*;
public class stackLinkedlistImp {
    // static class  Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class stackL {
    //     static Node head = null;

    //     public static boolean isEmpty() {
    //         return head == null;
    //     }

    //     public static void push (int data) {
    //         Node newnode = new Node(data);
    //         if(isEmpty()){
    //             head = newnode;
    //             return ;
    //         }
    //         newnode.next = head;
    //         head = newnode;
    //     }
    //     public static int pop() {
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }
    //     public static int peak () {
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return head.data;
    //     }

        public static void main(String[] args) {
            // stackL sL = new stackL();
            Stack <Integer> sL = new Stack<>();
            sL.push(1);
            sL.push(2);
            sL.push(3);
            sL.push(4);

            while(!sL.isEmpty()){
                System.out.println(sL.peek());
                sL.pop();
            }
        }
    
}
