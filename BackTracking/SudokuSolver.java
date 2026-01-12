import java.util.Arrays;

class SudokuSolver{
    public static void main(String[] args){
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Original board: ");
        printBoard(board);

        solveSudoku(board);

        System.out.println("Solved board: ");
        printBoard(board);

    }
    public static boolean isSafe(char[][] board,int row,int col,char dig){
        // Check the row
        for(int j=0;j<9;j++){
            if(board[row][j]==dig){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==dig){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<=sr+2;i++){
            for(int j=sc;j<=sc+2;j++){
                if(board[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper(char[][] board,int row,int col){
        if(row==9){
            return true;
        }
        int nextRow=row;
        int nextCol=col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(board[row][col] !='.'){
            return helper(board, nextRow, nextCol);
        }
        for(char dig='1';dig<='9';dig++){
            if(isSafe(board, row,col, dig)){
                board[row][col]=dig;
                if(helper(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public static void solveSudoku(char[][] board){
        helper(board,0,0);
    }
    public static void printBoard(char[][] board){
        for(char[] i: board){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
}