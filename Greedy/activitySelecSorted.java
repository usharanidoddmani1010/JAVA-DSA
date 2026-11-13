package Greedy;

import java.util.ArrayList;

public class activitySelecSorted {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        // end timee basis sorted 
        int maxAct = 0;
        ArrayList  <Integer> ans = new ArrayList<>(); // this is used to get the selected 

        //first add the first metting in the ans
        maxAct = 1;
        ans.add(0);  // this stores the index val
        int lastEnd = end[0];
        for(int i = 1; i < end.length; i++) {
            if(start[i] >= lastEnd) { // select the activity
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("max acitivities = "+ maxAct);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+ " ");
        }

        System.out.println();
    }
}
