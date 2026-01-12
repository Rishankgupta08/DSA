import java.io.*;
import java.util.*;
public class RectangleCutting{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            boolean possible=false;
            if (a % 2 == 0 && (a / 2 != b)) {
                possible = true;
            }
            if (b % 2 == 0 && (b / 2 != a)) {
                possible = true;
            }

            if (possible) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
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