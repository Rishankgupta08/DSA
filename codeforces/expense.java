import java.util.Arrays;
class expense{
    public static void main(String[] args){
        int[] arr={5, 2, 3, 10, 6, 8};
        int target=10;
        int n=arr.length;
        int[][] dp = new int[n][target + 1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        System.out.println(solve(arr,0,n-1,target, dp));
    }
    public static int solve(int[] arr,int idx,int n,int target,int[][] dp){
        if(target==0){
            return 1;
        }
        if(idx==n){
            if(target-arr[idx]==0){
                return 1;
            }else{
                return 0;

            }
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        
        int notpick=solve(arr,idx+1,n,target, dp);
        int pick=solve(arr,idx+1,n,target-arr[idx], dp);
        return dp[idx][target] = pick+notpick;
    }
}