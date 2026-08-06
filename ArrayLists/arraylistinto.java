package ArrayLists;
import java.util.ArrayList;
public class arraylistinto {
    public static void Swap(ArrayList <Integer> list, int idx1, int idx2){
        int temp=list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
        System.out.println("after swaping list is: ");
        for(int i=0;i<list.size();i++){
            System.out.print( list.get(i)+" ");
        }
        System.err.println();

    }
    public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<>(); /* which is very similar to 
    classname objectname= new classname(); */
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.add(4,6);
    System.out.println(list);

    //get element O(1)
    int ele=list.get(2);
    System.out.println(ele); 

    //remove element O(n)
    list.remove(2);
    System.out.println(list);

    //set element at the index 
    list.set(2,10);
    System.out.println(list);

    // containes
    System.out.println(list.contains(5));
    System.out.println(list.contains(1));

    // size()
    System.out.println(list.size());

    for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
    }
    System.err.println();


    // print the reverse of the arraylist   O(n)
    System.out.println("the reverse of the arraylist is:");
    for(int i=list.size()-1;i>=0;i--){
        System.out.print(list.get(i)+" ");
    }
    System.err.println();


    //maximum of the Arraylist
    System.out.println("The maximum element in the arraylist is:");
    int max=Integer.MIN_VALUE;
    for(int i=0;i<list.size();i++){
        max=Math.max(max, list.get(i));
    }
    System.out.println(max);


    // swap two number at the given index

    int idx1=0, idx2=2;
    System.out.print(list);
    System.out.println();
    Swap(list, idx1, idx2);
    System.out.print(list);





    }
}
