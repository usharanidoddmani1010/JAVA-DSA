import  java.util.*;
public class DoubleLL {
    public static class Node {  // class
        int data;
        Node next;
        Node prev;

        public Node (int data){ // construsture
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
    }// class end
    public static Node head; 
    public static Node tail;
    public static int size;


    // add

    // add first
    public void addFirst(int data){

        Node newNode = new Node(data);
        size++;
        // base condtion
        if(head == null){
            head = tail = newNode;
            return; 
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode; // imp
    }

    // add last
    public  void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return; 
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    } 

    // add in middle
    public void addMiddle(int data, int index){
        

        if( index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while( i != index-1 ){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    //print
    public void print(){

        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // remove
    
    // remove first
    public int removeFist(){
        // empty
        if(head == null){
            System.out.println("The dll is empty");
        }
        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size --;
            return val;
        }
        // size--;
        // head.next.prev = null;
        // head = head.next;

        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }
    
    // remove last
    public int removeLast(){
        if(head == null){
            System.out.println("The dll is empty");
        }
        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size --;
            return val;
        }

        // size--;
        // tail.prev.next = null;
        // tail = tail.prev;
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    // remove from middle
    public int removeMiddle(int index){
        if( index == 0 ){
            removeFist();
        }
        size--;
        Node temp = head;
        int i = 0;
        while (i != index-1){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        return val;
    }

    // reverse dll

    public void reverseDll(){
        Node curr = head;
        Node prev = null;
        Node next;

        while( curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;  // only one extra step;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // main
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();  // same as the file name
        dll.addFirst(1);   // if my method is static then i need to write this The static method addFirst(int) from the type DoubleLL should be accessed in a static way
        dll.addFirst(0);  // why, static belongs to the class, not to a particular object.
        dll.addLast(2);
        dll.addLast(4);
        dll.addMiddle(3, 3);
        dll.print();
        System.out.println("removed:"+ dll.removeFist());
        dll.print();
        System.out.println("removed:"+dll.removeLast());
        dll.print();
        System.out.println("removed:"+dll.removeMiddle(1));
        dll.print();
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.print();
        dll.reverseDll();
        dll.print();



    }
}
