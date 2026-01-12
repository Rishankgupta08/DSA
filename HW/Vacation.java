import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Vacation{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int[][] points=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                points[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][4];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(points,n-1,3,dp));
    }
    public static int solve(int[][] points,int idx,int last,int[][] dp){
        if(idx==0){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        if(dp[idx][last] != -1){
            return dp[idx][last];
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(last!=i){
                maxi=Math.max(maxi,solve(points,idx-1,i,dp)+points[idx][i]);
            }
        }
        return dp[idx][last]=maxi;
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
