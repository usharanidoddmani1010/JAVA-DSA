package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activitySelUnsorted {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,10,6,7,9,9};

        // if not sorted then sort
        int acitivities[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++) {
            acitivities[i][0] = i; // in first col sotring the index
            acitivities[i][1] = start[i]; // storing val of start in the 2nd col
            acitivities[i][2] = end[i];// storing val of end n the 3rd val
        }

        Arrays.sort(acitivities, Comparator.comparingDouble(o->o[2]));
        // end timee basis sorted 
        int maxAct = 0;
        ArrayList  <Integer> ans = new ArrayList<>(); // this is used to get the selected 

        //first add the first metting in the ans
        maxAct = 1;
        ans.add(acitivities[0][0]);  // this stores the index val
        int lastEnd = acitivities[0][2];
        for(int i = 1; i < end.length; i++) {
            if(acitivities[i][1] >= lastEnd) { // select the activity
                maxAct++;
                ans.add(acitivities[i][0]);
                lastEnd = acitivities[i][2];
            }
        }

        System.out.println("max acitivities = "+ maxAct);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+ " ");
        }

        System.out.println();
    }
}
