package linkList;
import java.util.*;
// import java.util.*;

/**
 * linkListBase
 */
public class linkListBase {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    // metheod
    //add()---------   2 ways 
    
    // addfirst

    public void addFirst(int data){

        
        // step-1  create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        // step=2 newnod nest==head
        newNode.next=head;

        // step=3 head=newnode
        head=newNode;

    }

    //addLast

    public void addLast(int data){

        // step-1 create new node
        Node newN = new Node(data);
        size++;
        if(head==null){
            head=tail=newN;
            return;
        }
        

        // step-2 tail.next= newNode
        tail.next=newN;

        // step-3 tail=newNode
        tail=newN;

    }

    // add in middle
    public void add(int index, int data){
        // if ind val is 0 call addfirst
        if(index==0){
            addFirst(data);
            return;
        }
        // step-1 create newnode
        Node newNd=new Node(data);
        size++;

        // step-2 travserval untill index value
        Node tmp = head;
        int i=0;

        while(i<index-1){
            tmp=tmp.next;
            i++;
        }
        newNd.next=tmp.next;
        tmp.next=newNd;
    }


    // remove()
    // 2 ways  

    // removeFirst
    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val= head.data;
            head=tail=null;
            size=0;
            return val;
            
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    //remove last

    public int removeLast(){
         if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
         }
         else if(size==1){
            int val= head.data;
            head=tail=null;
            size=0;
            return val;
         }
         Node temp=head;
         for(int i=0;i<size-2;i++){
            temp=temp.next;
         }
         int val=head.data;
         temp.next=null;
         tail=temp;
         size--;
         return val;
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


    // search

    // itSearch
    public int itSearchKey(int key){
        int i=0;
        Node temp=head;
        while (temp!=null) {
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    //recurstion seach

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx==-1){
            return -1;
        }
        return idx+1;
        
    }
    public int recuSearch(int key){
        return helper(head, key);
    }


    // Revese a ll

    // 3 var and 4 steps

    public void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }


    // find and remove nth node from end

    // itrative approach

    public void deleteNthfromEnd(int n){
        // calculte size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n == sz) {
            head = head.next;  //remove first
            return;
        }

        // sz-n
        int i = 1;
        int iToFind=sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }



    ///////////////////////////////////////////////
    ///  check if ll is palindrom or not
    
    
    // step-1 find midNode
    // slow fast approach
    public Node findMide(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow=slow.next;  //+1
            fast=fast.next.next;  //+2
            
        }
        return slow;
    }

    // step 2 reverse the second half
    public boolean checkPalindrome(){
        // base case
        if(head == null || head.next == null){
            return true;

        }
        // step 1  findmid
        Node midNode = findMide(head);

        // step 2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;  // only change in the reverse is there it is head here forom the middle 
        Node next;
         while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         Node right = prev;  
         Node left = head;

        // step 3 check left half and right half
        while(right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }



    ////////////////////////////////////////////////////////////////
    
    // detection of cycle

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            // slow = slow + 1;
            // fast = fast + 2;  never right like this 

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////
    
    // Remove a loop cycle in a LL

    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true; // why i done this is i want fast to there only after it will used for the +1 increment
                break;
            }
        }
        if(cycle == false){
            return;
        }
       
        // find meeting point by using s and f as incre by 1
        slow = head;

        // corner case if cycle detect at the start
        if(slow == fast){
            while( fast.next != slow){
                fast = fast.next;
            }
            // remove cycle -> last.next = null
            fast.next = null;
        }

        // corner case if cycle detect at middle
        else{
            Node prev = null; // last node
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            // remove cycle -> last.next = null
            prev.next = null;
        }
        

    }

    //mergesort of ll in jcf
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    private Node merge (Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while ( head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head) {  // O(nlogn)
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // left and rith MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    ////////////////////////////////////////////////////////////////

    // Zig Zag LL

    public void zigZag(){
       
        // find the mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // rever 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev; // bcz prev is at last so head
        Node nextL, nextR;

        // alt merge -zig zag
        while( left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
            
        }

    }
    public static void main(String[] args) {
        linkListBase ll = new linkListBase();
        // ll.head=new Node(1);
        // ll.head.next=new Node(2);
        // rather than writing code in main fun we can make a methods
        
    
        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addFirst(5);

        // ll.addLast(0);
        // ll.addLast(-1);
        // ll.addLast(-2);


        // // add in anywhere

        // ll.add(2,2);
        // ll.add(0, 6);
        // ll.print();

        // System.out.println(ll.size);


        // // remove first
        // ll.removeFirst();
        // ll.print();


        // // remove last
        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.size);

        // //itsearch

        // System.out.println("the key found at postion: "+ll.itSearchKey(0));
        // System.out.println("the key found at postion: "+ll.itSearchKey(-2));
       
        // // recusive search

        // System.out.println("the key found at postion: "+ll.recuSearch(2));
        // System.out.println("the key found at postion: "+ll.recuSearch(-5));

        // // reverse

        // ll.reverseLL();
        // ll.print();


        // // delete the nth node from the end

        // // suppose 3rd node from the end
        // ll.deleteNthfromEnd(3);
        // ll.print();


        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.add(2, 3);
        // ll.print();


        // System.out.print("palindrom: "+ll.checkPalindrome());





        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;

        // 1->2->3->1

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1->2->3->2

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addFirst(5);

        // ll.addLast(0);
        // ll.addLast(11);
        // ll.addLast(8);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        // zig zag
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        ll.zigZag();
        ll.print();

    
    }
}