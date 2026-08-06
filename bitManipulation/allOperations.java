package bitManipulation;

public class allOperations {
    public static void oddEven(int n){
        int bitMask=1;
        // for even num lsb always 0, and odd lsb always 1
        // so to know even or odd we do the and operation with the 1 
        // for even 0&1 give 0 and for 1&1=1 so it is odd
        if((n & bitMask)==0){ 
            System.out.println(n + " is even");
        }
        else{
            System.out.println(n + " is odd");
        }
    }
    public static void main(String[] args) {
       System.out.println(2<<3);   //for left shift a*2^b = 2*2^3=16
       System.out.println(2>>3); //for right shift a/2^b = 2/2^3=0


       int n=16;
       oddEven(n); 

       int x=3;
       oddEven(x);
    }
    

}
