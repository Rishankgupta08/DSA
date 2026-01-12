import java.io.*;
import java.util.*;
class countingNotadj{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();

        String l=String.valueOf(a-1);
        String r=String.valueOf(b);
        Long[][][][] dp1=new Long[20][2][11][2];
        Long[][][][] dp2=new Long[20][2][11][2];
        long ans=solve(r,0,1,10,1,dp1) -solve(l,0,1,10,1,dp2);
        System.out.println(ans);
    }

    private static long solve(String s, int idx, int tight, int prev, int lz,Long[][][][]dp) {
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][prev][lz] != null){
            return dp[idx][tight][prev][lz];
        }
        int lb=0;
        int ub=(tight==1)? s.charAt(idx)-'0': 9;
        long res=0;
        for(int digit=lb;digit<=ub;digit++){
            if(lz==0 && digit==prev){
                continue;
            }
            int newTight=(tight==1 && digit==ub)? 1 : 0;
            int newLZ=(lz==1 && digit==0)? 1: 0;
            res+=solve(s,idx+1,newTight,digit,newLZ,dp);
        }
        return dp[idx][tight][prev][lz]=res;
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