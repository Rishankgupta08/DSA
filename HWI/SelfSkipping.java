package HWI;

import java.util.Scanner;

public class SelfSkipping {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Integer[] dp=new Integer[n];
        int ans=solve(0,n,arr,dp);
        System.out.println(ans);
    }
    public static int solve(int idx,int n,int[] arr,Integer[] dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        int nottake=solve(idx+1,n,arr,dp);
        int take=arr[idx];
        if(idx+arr[idx]+1<n){
            take=arr[idx]+solve(idx+arr[idx]+1,n,arr,dp);
        }
        return dp[idx]=Math.max(nottake,take);
    }
}
