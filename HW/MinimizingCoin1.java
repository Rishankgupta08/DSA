import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.util.StringTokenizer;
class MinimizingCoin1 {
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] coin=new int[n];
        for(int i=0;i<n;i++){
            coin[i]=sc.nextInt();
        }
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=target;j++){
            if(j%coin[0]==0){
                dp[0][j]=j/coin[0];
            }else{
                dp[0][j]=(int)1e9;
            }
        }
 
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                int nottake=dp[i-1][j];
                int take=(int)1e9;
                if(coin[i]<=j){
                    take=1+dp[i][j-coin[i]];
                }
                dp[i][j]=Math.min(take,nottake);
            }
        }
 
        System.out.println((dp[n-1][target]>=(int)1e9? -1: dp[n-1][target]));
    }
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