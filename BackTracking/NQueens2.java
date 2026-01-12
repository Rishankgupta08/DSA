import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class NQueens2{
    public static boolean isSafe(char[][] board,int row,int col ,int n){
        for(int j=0;j<n;j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;

    }
    public static void nqueens(char[][] board,int row,int n,List<List<String>> ans){
        if(row==n){
             List<String> temp = new ArrayList<>();
            for (char[] b : board) {
                temp.add(new String(b));
            }
            ans.add(temp);
            return;
        }

        for(int j=0;j<n;j++){
            if(isSafe(board,row,j,n)){
                board[row][j]='Q';
                nqueens(board,row +1,n,ans);

                board[row][j]='.';
            }
        }
    }

    public static int totalNQueens(int n) {
         char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        nqueens(board,0,n,ans);
        return ans.size();
    }
    public static void main(String[] args){
        int n=4;
        int l=totalNQueens(n);
        System.out.println(l);
    }
}