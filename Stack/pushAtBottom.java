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
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottomS(s, 4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
       }
    
    }
}
    
