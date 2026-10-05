package Stack;

import java.util.Stack;

public class validParenthsis {
    public static boolean isValidParenthsis(String str) {
        Stack <Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '[' || c == '(' || c == '{') {
                s.push(c);
            }
            else if (c == ']' || c == ')' || c == '}'){
   
                if(s.isEmpty()){
                    return false;
                }else if (c == ']' && s.peek()=='[' ||
                          c == ')' && s.peek()=='(' ||
                          c == '}' && s.peek()=='{'){

                            s.pop();
                          }
            }

        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String str = "({})";
        System.out.println(isValidParenthsis(str));
    }
}
