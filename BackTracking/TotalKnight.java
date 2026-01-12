import java.util.ArrayList;
import java.util.List;

class TotalKnight{
    static int max=0;
    public static void main(String[] args){
        int n=4;
        char[][] grid=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='x';
            }
        }
        List<List<String>> res=new ArrayList<>();
        solve(grid,0,0,0,res);
        System.out.println(res);
    }
    public static void solve(char[][] grid,int row,int col,int num,List<List<String>> ans){
        int n=grid.length;
        if(row==n ){
            max=Math.max(max,num);
            List<String> temp = new ArrayList<>();
            for (char[] b : grid) {
                temp.add(new String(b));
            }
            ans.add(temp);
            return;
        }
        if(isSafe(grid,row,col,n)){
            grid[row][col]='k';
            if(col!=n-1){
                solve(grid,row,col+1,num+1,ans);
            }else{
                solve(grid,row+1,0,num+1,ans);
            }
            
            grid[row][col]='x';
        }else{
            if(col!=n-1){
                solve(grid,row,col+1,num,ans);
            }else{
                solve(grid,row+1,0,num,ans);
            }
        }
    }
    private static boolean isSafe(char[][] grid, int row, int col, int n) {
        int i,j;
        // 2up 1 right
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j]=='k'){
            return false;
        }
        // 2up 1 left
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j]=='k'){
            return false;
        }
        // 2 left 1 up
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j]=='k'){
            return false;
        }
        // 2 left 1 down
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j]=='k'){
            return false;
        }
        // 2 right 1 up
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j]=='k'){
            return false;
        }
        // 2 right 1 down
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j]=='k'){
            return false;
        }
        // 2down 1 right
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j]=='k'){
            return false;
        }
        // 2 down 1 left
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j]=='k'){
            return false;
        }
        return true;
    }
    
}