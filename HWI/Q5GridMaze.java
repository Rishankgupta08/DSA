package HWI;

import java.util.Arrays;
import java.util.Scanner;

class Q5GridMaze{
    static final int MOD=1_000_000_007;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        char[][] grid=new char[n][m];
        for(int i=0;i<n;i++){
            grid[i]=sc.next().toCharArray();
        }

        long[][][] dp=new long[n][m][2];
        long[][][] ndp=new long[n][m][2];

        dp[0][0][0]=1;
        dp[0][0][1]=1;

        long ans=0;
        for(int day=1;day<=k;day++){
            for(long[][] a: ndp){
                for(long[] b: a){
                    Arrays.fill(b,0);
                }
            }
            for(int r=0;r<n;r++){
                for(int c=0;c<m;c++){
                    if(grid[r][c]=='#') continue;

                    if(dp[r][c][0]>0){
                        for(int nr=r-1;nr>=0;nr--){
                            if(grid[nr][c]=='#') break;
                            ndp[nr][c][1]=(ndp[nr][c][1]+dp[r][c][0])%MOD;
                        }
                        for(int nr=r+1;nr<n;nr++){
                            if(grid[nr][c]=='#') break;
                            ndp[nr][c][1]=(ndp[nr][c][1]+dp[r][c][0])%MOD;
                        }
                    }

                    if(dp[r][c][1]>0){
                        for(int nc=c-1;nc>=0;nc--){
                            if(grid[r][nc]=='#') break;
                            ndp[r][nc][0]=(ndp[r][nc][0]+dp[r][c][1])%MOD;
                        }
                        for(int nc=c+1;nc<m;nc++){
                            if(grid[r][nc]=='#') break;
                            ndp[r][nc][0]=(ndp[r][nc][0]+dp[r][c][1])%MOD;
                        }
                    }
                }
            }

            long[][][] temp=dp;
            dp=ndp;
            ndp=temp;
            ans=(ans+dp[0][0][0]+dp[0][0][1])%MOD;
        }
        System.out.println(ans);
        sc.close();
    }
}