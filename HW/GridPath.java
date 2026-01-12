import java.util.Scanner;

class GridPath{
    static final int MOD = 1_000_000_007;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next();
        }

        if(grid[0].charAt(0)=='*'){
            System.out.print(0);
            return;
        }
        int[][] dp=new int[n][n];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='*'){
                    dp[i][j]=0;
                }else{
                    if(i>0) {
                        dp[i][j]=(dp[i][j]+dp[i-1][j])% MOD;
                    }
                    if(j>0) dp[i][j]=(dp[i][j]+dp[i][j-1])% MOD;
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

}