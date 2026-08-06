package backt;

public class Sudoku {
    public static boolean isSafe(int sudokus[][], int row , int col, int digit){
        //coloum check so row fiexed
        for(int j=0;j<=8;j++){
            if(sudokus[row][j]==digit){
                return false;
            }
        }

        //row check so col fiexed
        for (int i=0;i<=8;i++){
            if(sudokus[i][col]==digit){
                return false;
            }
        }
        //grid check  explantion in my notes see that
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudokus[i][j]==digit){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean sudokuSolve(int sudokus[][],int row , int col){
        //base case
        if(row==9){
            return true;
        }
        //recursion
        int nexRow=row, nexCol=col+1; //why only incrementing because col changes every time and 
        // row changes only when col=9
        if(col+1==9){
            nexRow=row+1;
            nexCol=0;
        }
        // if i already have element in the cell then i don't need to put element if empty then only
        if(sudokus[row][col]!=0){
            return sudokuSolve(sudokus, nexRow, nexCol);
        }
        //for digit to add in the sudoku start from 1 because 0 means nothing 
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudokus,row, col, digit)){
                sudokus[row][col]=digit;
                if(sudokuSolve(sudokus, nexRow, nexCol)){
                    return true; // means solution is found no need to find another solution 
                    // means no need of backtrack
                }
                sudokus[row][col]=0;
            }
        }
        return false;
    }
    public static void printsudoku(int sudokus[][]){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.print(sudokus[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudokus[][]={{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},{0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},{0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},{0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},{8,2,7,0,0,9,0,1,3}};
    
        if(sudokuSolve(sudokus,0,0)){
            System.out.println("Solution exists:");
            printsudoku(sudokus);
        }
        else{
            System.out.println("Solution doesn't exists");
        }
    }
}
