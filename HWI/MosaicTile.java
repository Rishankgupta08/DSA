package HWI;

import java.util.Scanner;

class MosaicTile{
    static int n;
    static int m;    
    static int costA;    
    static int costB;    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        costA=sc.nextInt();
        costB=sc.nextInt();

        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int total=0;
        for(int i=0;i<n;i++){
            Integer[] dp=new Integer[m+1];
            total+=solve(i,0,arr,dp);
        }
        System.out.println(total);
    }
    public static int solve(int i,int j,int[][] arr,Integer[]dp){
        if(j==m) return 0;
        if(dp[j]!=null){
            return dp[j];
        }
        int best=(costA-arr[i][j])+solve(i,j+1,arr,dp);
        if(j+1<m){
            best=Math.min(best,costB+solve(i,j+2,arr,dp));
        }
        return dp[j]=best;
    }
}