class ClimbingStairs{
    public static void main(String[] args){
        int n=3;
        int k=3;
        int[] dp=new int[n+1];
        int count=stairs(n,k,dp);
        System.out.println(count);
    }
    public static int stairs(int n,int k,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(k<0){
            return 1;
        }
        dp[n]+=stairs(n, k-1, dp);
        return dp[n];
    }
}