package HWI;

import java.util.Scanner;

class MaximumModuloSum{
    static int n;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Integer[][] dp=new Integer[n][n+1];
        int ans=solve(0,-1,k,arr,dp);
        System.out.println(ans);
    }
    public static int solve(int idx,int prev,int k,int[] arr,Integer[][] dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev+1]!=null){
            return dp[idx][prev+1];
        }
        int nottake= solve(idx+1,prev,k,arr,dp);
        int take=Integer.MIN_VALUE;
        if(arr[idx]%k!=prev){
            take=arr[idx]+solve(idx+1,arr[idx]%k,k,arr,dp);
        }
        return dp[idx][prev+1]=Math.max(take,nottake);
    }
}