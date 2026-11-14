package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fracKnapsack {
    public static void main(String[] args) {
        int val[]= {60,100,120};
        int wt[] = {10,20,30};
        int capcity = 50;

        double ratio[][] = new double[wt.length][2];

        // the ratio stores the answer in ascending but i want in descending so next the for loop start from the end
        for(int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)wt[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int ans = 0;
        for(int i = ratio.length-1; i >=0; i--) {
            int idx = (int)ratio[i][0];
            if(capcity >= wt[idx]) {
                capcity -= wt[idx];
                ans += val[idx];
            }else {
                ans = ans + ((int)ratio[i][1]*capcity);
                capcity = 0;
                break;
            }
        }
        System.out.println("final value= "+ ans);
    }
}
