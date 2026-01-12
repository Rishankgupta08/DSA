import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CoinCombination{
    static final int MOD = 1000000007;
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n; i++) {
            coins[i]=sc.nextInt();
        }
        long[] dp=new long[x+1];

        dp[0]=1;
        for(int i=1;i<=x;i++){
            for(int j: coins){
                if(i-j>=0){
                    dp[i]=(dp[i]+dp[i-j])%MOD;
                }
            }
        }
        System.out.println(dp[x]);
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