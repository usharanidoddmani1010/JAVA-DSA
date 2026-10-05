package Stack;

import java.util.Stack;

public class pushAtBottom {

    public static void pushAtBottomS(Stack<Integer> ps, int data ){
        if(ps.isEmpty()){
            ps.push(data); // pushing 4 to bottom 
            return;
        }

        int top = ps.pop(); // remove the top element and then call pushbottom 
        pushAtBottomS(ps, data); // call again if not empty same take out 
        ps.push(top); // once return then push back to stack 
    }

    public static String revesString (String str) {
        Stack <Character> s = new Stack<>();
        int idx = 0;

        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder st = new StringBuilder();
        while (!s.empty()) {
            st.append(s.pop());
        }
        return st.toString();
    }

    public static void revesStack(Stack <Integer> s) {
        if(s.isEmpty()){
            return; // reversing the empty stack is easy so we just return don't send any value
        }

        int top = s.pop();  // store the curr top
        revesStack(s);  // call this untill stack become empty and when stack empty then it start calling the pushatbootm
        pushAtBottomS(s, top); // here when stack empty then this start adding the values to the bottom so how we get the reversed stack
    }

    public static void printStack(Stack <Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());   
        }
    }

    
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // pushAtBottomS(s, 4);

    //     while(!s.isEmpty()){
    //         System.out.println(s.peek());
    //         s.pop();
    //    }
    
    //    // reverse string
    //    String str = "usha";
    //    System.out.println(revesString(str));

       // reverse stack
       // 3,2,1  // don't write the print here beacuse the print make the stack empty so for the reverse we don't have the element so 
       revesStack(s);
       printStack(s); // 1,2,3

       
    }
}
    
