import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KuriyamaStone{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        long [] copy=new long[n];
        for(int i=0;i<n;i++){
            copy[i]=arr[i]=sc.nextLong();
        }
        Arrays.sort(copy);
        long[] pref1=new long[n+1];
        long[] pref2=new long[n+1];
        for(int i=1;i<=n;i++){
            pref1[i]=pref1[i-1]+copy[i-1];
            pref2[i]=pref2[i-1]+arr[i-1];
        }
        int q=sc.nextInt();
        while(q-- > 0){
            int type=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            if(type==2){
                System.out.println(pref1[r]-pref1[l-1]);
            }else{
                System.out.println(pref2[r]-pref2[l-1]);
            }
        }
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