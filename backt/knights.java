package backt;


public class knights {
    static int count=0;
    public static boolean isSafe(char board[][], int row, int col) {
    int n = board.length;

    // move: (row-1, col-2)
    if (row-1 >= 0 && col-2 >= 0 && board[row-1][col-2] == 'K') {
        return false;
    }

    // move: (row-1, col+2)
    if (row-1 >= 0 && col+2 < n && board[row-1][col+2] == 'K') {
        return false;
    }

    // move: (row-2, col-1)
    if (row-2 >= 0 && col-1 >= 0 && board[row-2][col-1] == 'K') {
        return false;
    }

    // move: (row-2, col+1)
    if (row-2 >= 0 && col+1 < n && board[row-2][col+1] == 'K') {
        return false;
    }

    return true;
}
    public static void NKnights(char board[][], int row, int mat[][]){
        //base condition
        if(row==board.length){
            print(board,mat);
            return;
        }
        //how many ways we can put the queens
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='K';
                count++;
                mat[row][j]=count;

                NKnights(board, row+1,mat); // function call to put the queens in next row
                board[row][j]='x';/*  // backtracking when all posible row is done when i 
                // come to go next colm for other combination */
                // 
            }
        } 
    }
    public static void print(char board[][], int mat[][]){
        System.out.println("---chess board---");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        } 
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
               System.out.print(mat[i][j]+" ");
            }
            System.out.println(" ");
        } 
    }
    public static void main(String[] args) {
        int n=3;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        int mat[][]=new int[n][n];
          for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=0;
            }
        }
        NKnights(board,0,mat);
    }
    
}
