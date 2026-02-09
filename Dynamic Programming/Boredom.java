import java.util.Scanner;

public class Boredom{
    static long[] freq;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        freq=new long[100001];
        int max=0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            freq[arr[i]]++;
            max=Math.max(max,arr[i]);
        }
        Long[] dp=new Long[max+1];
        long ans=solve(max,dp);
        System.out.println(ans);

    }
    public static long solve(int i,Long[] dp){
        if (i <= 0) return 0;
        if(dp[i]!=null){
            return dp[i];
        }
        long nottake=solve(i-1,dp);
        long take=i*freq[i]+solve(i-2,dp);
        return dp[i]=Math.max(take,nottake);
    }
}