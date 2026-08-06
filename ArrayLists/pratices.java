package ArrayLists;
import java.util.ArrayList;
import java.util.Collections;
public class pratices {
    public static void swap(ArrayList<Integer> list, int i1, int i2) {

        int temp = list.get(i1);

        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
    public static void main(String[] args) {
         ArrayList<Integer> list=new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         int l=list.size();
         for(int i=l-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
         }
         System.out.println();
         int max=Integer.MIN_VALUE;
         for(int i=0;i<l;i++){
            max=Math.max(max,list.get(i)); 
         }
         System.out.println(max);
         System.out.println();

         int i1=1,i2=2;
         swap(list,i1,i2);
         System.out.println(list);
         

         ArrayList <Integer> li=new ArrayList<>();
         li.add(5);
         li.add(7);
         li.add(3);
         li.add(2);
         System.out.println(li);
         /* ascending  */
         Collections.sort(li);
         System.out.println(li);
         /* descending */
         Collections.sort(li,Collections.reverseOrder());
         System.out.println(li);


    }
    
}
