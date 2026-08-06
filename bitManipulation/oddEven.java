package bitManipulation;
import java.util.*;
public class oddEven {

    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        System.out.println("enter number: ");
        int a=sn.nextInt();
        int bitMask=1;
        if ((a & bitMask)==0) {
            //even 
            System.out.println("the number is even");
        }else{
            System.out.println("the number is odd");
        }
        sn.close();
    }

}