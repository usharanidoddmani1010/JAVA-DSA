public class findsubstring {
    public static void fs(String str, String ans, int i){
        //base cond
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
               
            }else{
                System.out.println(ans);
            
            }
             return;
        }
        
        
        //recursion
        // yes add charcter
        fs(str, ans+str.charAt(i), i+1);
        // no 
        fs(str, ans, i+1);

    }
    public static void main(String[] args) {
        String str="abc";
        fs(str,"" ,0);
    }
    
}
