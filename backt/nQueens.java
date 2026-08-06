package backt;

public class nQueens {
    public static boolean isSafe(char board[][], int row, int col){
        //verticaly up  (here why we checking only up not 
        // down because we started adding the queens from the top so)
        for(int i=row-1;i>=0;i--){
           
            if(board[i][col]=='Q'){
                return false;
        }

        }
        // right diag
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
           
            if(board[i][j]=='Q'){
                return false;
            }
            

        }
        //left diag
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
        
            if(board[i][j]=='Q'){
                return false;
            
            }

        }
        return true;
    }
    public static void NQueens(char board[][], int row){
        //base condition
        if(row==board.length){
            print(board);
            return;
        }
        //how many ways we can put the queens
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                NQueens(board, row+1); // function call to put the queens in next row
                board[row][j]='x';/*  // backtracking when all posible row is done when i 
                // come to go next colm for other combination */
                // 
            }
        } 
    }
    public static void print(char board[][]){
        System.out.println("---chess board---");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        } 
    }
    public static void main(String[] args) {
        int n=5;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        } 
        NQueens(board,0);
    }
    
}
