import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClassyNo{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();

        while(t-- > 0){
            long a=sc.nextLong();
            long b=sc.nextLong();

            String s1=String.valueOf(a-1);
            String s2=String.valueOf(b);

            Long[][][] dp1=new Long[19][2][4];
            Long[][][] dp2=new Long[19][2][4];
            long ans=solve(s2,0,1,0,dp1)-solve(s1,0,1,0,dp2);
            System.out.println(ans);
        }
    }
    public static long solve(String s,int idx,int tight,int count,Long[][][] dp){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][count] != null){
            return dp[idx][tight][count];
        }
        int lb=0;
        int ub=(tight==1)? s.charAt(idx)-'0': 9;
        long res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newTight=(tight==1 && digit==ub)? 1 : 0;
            if(digit>0){
                if(count==3){
                    continue;
                }
                res+=solve(s, idx+1, newTight, count+1,dp);
            }else{
                res+=solve(s,idx+1,newTight,count,dp);
            }
        }
        return dp[idx][tight][count]=res;
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