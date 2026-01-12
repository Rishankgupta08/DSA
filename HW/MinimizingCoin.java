import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
// import java.util.Arrays;
import java.util.StringTokenizer;
class MinimizingCoin {
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] coin=new int[n];
        for(int i=0;i<n;i++){
            coin[i]=sc.nextInt();
        }
        int[] dp=new int[target+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;
        for(int i: coin){
            for(int j=i;j<=target;j++){
                dp[j]=Math.min(dp[j],dp[j-i]+1);
            }
        }
        System.out.println(dp[target] >= (int)1e9 ? -1 : dp[target]);
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
