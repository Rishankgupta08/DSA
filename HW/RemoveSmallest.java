import java.util.*;
import java.io.*;
public class RemoveSmallest{
    public static void main(String[]args){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++) a[i]=sc.nextInt();
            Arrays.sort(a);
            boolean valid=true;
            for(int i=0;i<n-1;i++){
                if(a[i+1]-a[i]>1){
                    valid=false;
                    break;
                }
            }
            if(valid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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