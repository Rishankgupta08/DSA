import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Removedigits{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();

        System.out.println(solve(n,0));
    }
    public static int solve(int n,int count){
        if(n==0){
            return count;
        }
        int max=0;
        int val=n;
        while(val>0){
            int rem=val%10;
            max=Math.max(rem,max);
            val=val/10;
        }
        return solve(n-max,count+1);
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