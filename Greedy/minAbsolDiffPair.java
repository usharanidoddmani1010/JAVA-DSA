package Greedy;

import java.util.Arrays;

public class minAbsolDiffPair {  //O(nlogn)
    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);
        int minAbsolDiffPairSum = 0;
        for(int i = 0; i < A.length; i++) {
            minAbsolDiffPairSum += Math.abs(A[i]-B[i]);
        }

        System.out.println("The min Absolute Difference Pair sum: "+ minAbsolDiffPairSum);
    }
}
