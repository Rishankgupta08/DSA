import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.util.StringTokenizer;

class DiceCombination{
    static final int MOD = 1000000007;
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();

        long[] dp=new long[n+1];
        // System.out.println(solve(n,dp));

        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=6;j++){
                if(i-j>=0){
                    dp[i]=(dp[i]+dp[i-j])%MOD;
                }
            }
        }
        System.out.println(dp[n]);
    }
    
    // private static long solve(int target,long[] dp) {
    //     if(target==0){
    //         return 1;
    //     }
    //     if(target < 0){
    //         return 0;
    //     }
    //     if(dp[target] != -1){
    //         return dp[target];
    //     }
    //     long count=0;
    //     for(int i=1;i<=6;i++){
    //         count=(count+solve(target-i,dp)) % MOD;
    //     }
    //     return dp[target]=count;
    // }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}