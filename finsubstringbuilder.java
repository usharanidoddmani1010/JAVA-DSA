public class finsubstringbuilder {
    public static void finsubstring_builder(StringBuilder str, StringBuilder ans, Integer i){
        if(i==str.length()){
           if(ans.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(ans.toString());
            }
            return;
        }
        // if character say yes
        finsubstring_builder(str, ans.append(str.charAt(i)), i+1);
        // if character say no
        finsubstring_builder(str, ans.deleteCharAt(ans.length()-1), i+1);


    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");  
        finsubstring_builder(str, new StringBuilder() , 0);
    }
    
}
