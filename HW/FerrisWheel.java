import java.util.Arrays;
import java.util.*;
import java.io.*;
public class FerrisWheel{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        long k=sc.nextLong();
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        long ans=wheel(a,k);
        System.out.println(ans);
    }
    public static long wheel(long[] a,long k){
        int n=a.length;
        Arrays.sort(a);
        long count=0;
        int i=0,
        j=n-1;
        while(i<=j){
            if(a[i]+a[j]<=k){
                i++;
            }
            j--;
            count++;
        }
        return count;
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
