import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.util.StringTokenizer;

class BookShop{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int cap=sc.nextInt();
        int[] wt=new int[n];
        int[] val=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }

        int[][] dp=new int[n+1][cap+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=cap;j++){
                int notake=dp[i-1][j];
                int take=-(int)1e9;
                if(wt[i-1]<=j){
                    take=val[i-1]+dp[i-1][j-wt[i-1]];
                }
                dp[i][j]=Math.max(take,notake);
            }
        }
        System.out.println(dp[n][cap]);
        // System.out.println(solve(n-1,cap,wt,val,dp));
    }
    // public static int solve(int idx,int cap,int[] wt,int[] val,int[][] dp){
    //     if(idx==0){
    //         if(wt[0]<=cap){
    //             return val[0];
    //         }else{
    //             return 0;
    //         }
    //     }
    //     if(dp[idx][cap]!=-1){
    //         return dp[idx][cap];
    //     }
    //     int nottake=solve(idx-1,cap,wt,val,dp);
    //     int take=-(int)1e9;
    //     if(wt[idx]<=cap){
    //         take=val[idx]+solve(idx-1,cap-wt[idx],wt,val,dp);
    //     }
    //     return dp[idx][cap]=Math.max(take,nottake);
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