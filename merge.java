import java.util.Arrays;
public class merge {
    public static void mergesort(int a[],int si, int ei){
        if(si>=ei){
            return ;
        }
        int mid=si+(ei-si)/2;
        mergesort(a, si, mid);
        mergesort(a, mid+1, ei);
        mergeall(a, si,mid,ei);
    }
    public static void mergeall(int a[],int si,int mid, int ei){
        int tem[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(a[i]<=a[j]){
                tem[k]=a[i];
                i++;
            }
            else{
                tem[k]=a[j];
                j++;
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
    }

    public static void main(String args[]){
        int a[]={2,0,7,5,9,6,1};
        mergesort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
        
}
