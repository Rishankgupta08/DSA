import java.io.*;
import java.util.*;
public class arrayopr {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long count = 0;
            for(int i = n - 1 ; i>= n - k ; i--){
                count += (long)Math.floor(arr[i - k]/ arr[i]);
            }
            for(int i = n - 2*k - 1 ; i >= 0; i--){
                count += arr[i];
            }
            System.out.println(count);
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
