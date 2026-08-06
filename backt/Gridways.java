package backt;

public class Gridways {
    public static int gridway(int x,int y, int n, int m){
        //base case
        if(x==n-1 && y==m-1){ // when x and y in the last cell
            return 1;
        }else if (x>=n || y>=m){ //when out of bound condition occure
            return 0;
        }
        //recursion
        //right ways
        int w1=gridway(x,y+1,n,m);
        int w2=gridway(x+1,y,n,m);
        return w1+w2;
    }
    public static void main(String[] args) {
        int n=3;
        int m=3;
        System.out.println("the number of ways are: "+gridway(0,0,n,m));

    }
    
}
