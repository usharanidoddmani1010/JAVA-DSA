import java.util.Arrays;

public class inversioncount {
    public static int mergesort(int a[],int si, int ei){
        if(si>=ei){
            return 0;
        }
        int mid=si+(ei-si)/2;
        int invleft=mergesort(a, si, mid);
        int invright=mergesort(a, mid+1, ei);
        int invmerge=mergeall(a, si,mid,ei);
        return invleft+invright+invmerge;
    }
    public static int mergeall(int a[],int si,int mid, int ei){
        int tem[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        int inversion=0;
        while(i<=mid && j<=ei){
            if(a[i]<=a[j]){
                tem[k]=a[i];
                i++;
            }
            else{
                tem[k]=a[j];
                j++;
                inversion+=(mid-i+1);
            }
            k++;

        }
        while(i<=mid){
            tem[k++]=a[i++];

        }
        while(j<=ei){
            tem[k++]=a[j++];

        }
        for (int ar = 0, b = si; ar < tem.length; ar++, b++) {
            a[b] = tem[ar];
        }
        return inversion;
    }

    public static void main(String args[]){
        int a[]={6,3,2,5,4};
        int m=mergesort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        System.out.println(m);
    }
    
}
