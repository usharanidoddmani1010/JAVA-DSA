package Stack;

import java.util.Stack;

public class stockSpan {
    public static void stockspanS(int Stock[], int Span[]) {
        Stack <Integer> s = new Stack<>();

        // span for the first element is always 1
        Span[0] = 1;
        s.push(0);

        for(int i = 1; i < Stock.length; i++) {

            // if the curr stock is greater than the prev remove the prev stock from the stack till curr stock becom the less
            while (!s.isEmpty() && Stock[i] > Stock[s.peek()]) {
                s.pop();
            }

            //if stack is empty means we reach the condtin where the stock price is higher than the previous all so 
            // i+1 because privous all day and today i am the high stock price so i is prev and +1 is me(today)
            if(s.isEmpty()) {  
                Span[i] = i+1;
            }  // calculating how much is it way from the grater value 
            else {
                int prev = s.peek();  // prevgreater idx
                Span[i] = i - prev; //curr idx - prevgreater idx 
            }
            s.push(i);
        }


    }
    public static void main(String[] args) {
        

        int Stock[] = {100,80,60,70,60,85,100};
        int Span[] = new int[Stock.length];

        stockspanS(Stock, Span);   

        for(int i = 0; i < Stock.length; i++) {
            System.out.println(Span[i] + " ");
        }
    }
}
