package Stack;

import java.util.Stack;

public class nextGreEle {

    // next greatest from right

    public static void nextGreatestElementRight (int arr[]) {
        Stack <Integer> s = new Stack<>();

        int result[] = new int[arr.length];
        
        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

        System.out.println("------------------------");
    }

    // it has 4 varitations 
    // next greatest from right 
    // next greastest from left  only for loop change 
    // next smallest from right  only condtion for pop changes  arr[i] < arr[s.peek()]
    // next smallest from left   both loop and condtion chages 


    // next greastest from left
    public static void nextGreatestElementLeft (int arr[]) {
        Stack <Integer> s = new Stack<>();

        int result[] = new int[arr.length];
        
        // only for loop change 
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println("------------------------");
    }

    // next smallest from right  only condtion for pop changes  arr[i] < arr[s.peek()]
    public static void nextSmallestElementRight (int arr[]) {
        Stack <Integer> s = new Stack<>();

        int result[] = new int[arr.length];
        
        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[i] < arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println("------------------------");
    }

    // next smallest from left   both loop and condtion chages 
    public static void nextSmallestElementLeft (int arr[]) {
        Stack <Integer> s = new Stack<>();

        int result[] = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[i] < arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,2,3};
        nextGreatestElementRight(arr);
        nextGreatestElementLeft(arr);
        nextSmallestElementRight(arr);
        nextSmallestElementLeft(arr);
    }
}
