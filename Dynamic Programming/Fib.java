// import java.util.Arrays;
class Fib{
    public static void main(String[] args){
        int n=5;
        //! Memoization
        // int[] dp=new int[n+1];
        // Arrays.fill(dp, -1);
        // int ans=fibo(n,dp);
        // System.out.println(ans);
        //! Tabulation
        // dp[0]=0;
        // dp[1]=1;
        // for(int i=2;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // System.out.println(dp[n]);
        //! for space optimization
        int prev1=0;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        } 
        System.out.println(prev2);
    }
    //! Memo
    // public static int fibo(int n,int[] dp){
    //     if(n<=1){
    //         return 1;
    //     }
    //     if(dp[n] !=-1){
    //         return dp[n];
    //     }
    //     return dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
    // }
}