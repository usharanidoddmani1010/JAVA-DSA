import java.util.LinkedList;

import linkList.linkListBase.Node;


public class javaCollecFrame {

    
    public static void main(String[] args) {
        // create (obj are used Integer, Float)
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(0);

        //print
        System.out.println(ll);
        
        // remove 
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
