import java.io.*;
import java.util.*;
class EditDistance{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        String s=sc.next();
        String t=sc.next();

        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take=Integer.MAX_VALUE;
                int nottake=Integer.MAX_VALUE;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    nottake=dp[i-1][j-1];
                }else{
                    take=Math.min(1+dp[i-1][j],Math.min(1+dp[i][j-1],1+dp[i-1][j-1]));
                }
                dp[i][j]=Math.min(take,nottake);
            }
        }
        System.out.println(dp[n][m]);
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