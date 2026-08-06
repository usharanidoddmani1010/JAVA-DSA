package linkList;

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
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
        
    }
    public int recuSearch(int key){
        return helper(head, key);
    }


    public static void main(String[] args) {
        linkListBase ll=new linkListBase();
        // ll.head=new Node(1);
        // ll.head.next=new Node(2);
        // rather than writing code in main fun we can make a methods
        
    
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(5);

        ll.addLast(0);
        ll.addLast(-1);
        ll.addLast(-2);


        // add in anywhere

        ll.add(2,2);
        ll.add(0, 6);
        ll.print();

        System.out.println(ll.size);


        // remove first
        ll.removeFirst();
        ll.print();


        // remove last
        ll.removeLast();
        ll.print();

        System.out.println(ll.size);

        //itsearch

        System.out.println("the key found at postion: "+ll.itSearchKey(0));
        System.out.println("the key found at postion: "+ll.itSearchKey(-2));
       
        // recusive search

        System.out.println("the key found at postion: "+ll.recuSearch(2));
        System.out.println("the key found at postion: "+ll.recuSearch(-5));
    }
}