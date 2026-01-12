import java.util.Arrays;
import java.util.*;
import java.io.*;
public class No_of_pairs{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            long ans=pair(a,r)-pair(a,l-1);
            System.out.println(ans);
        }
    }
    public static long pair(int[] a,int target){
        int n=a.length;
        long count=0;
        int i=0;
        int j=n-1;
        while(i<j){
            if(a[i]+a[j]<=target){
                count+=(j-i);
                i++;
            }else{
                j--;
            }
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
