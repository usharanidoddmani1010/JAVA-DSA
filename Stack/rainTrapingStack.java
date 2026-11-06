package Stack;
import java.util.Stack;

public class rainTrapingStack {
    public static void rainTraping(int arr[]) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        Stack <Integer> s = new Stack<>();
        s.push(0);
        
    }
    public static void main(String[] args) {
        int arr[] = {7,0,4,2,5,0,6,4,0,6};
        rainTraping(arr);
    }
}
