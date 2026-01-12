import java.io.*;
import java.util.*;

public class MaxSubArraysum2 {

    static final long INF = (long) 1e18;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            String s = sc.next();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();

            // Step 1: Kadane on fixed values
            long maxFixed = Long.MIN_VALUE, curr = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    curr += a[i];
                    maxFixed = Math.max(maxFixed, curr);
                    if (curr < 0) curr = 0;
                } else {
                    curr = 0;
                }
            }
            if (maxFixed == Long.MIN_VALUE) maxFixed = 0;

            if (maxFixed > k) {
                out.append("No\n");
                continue;
            }

            if (maxFixed == k) {
                out.append("Yes\n");
                for (int i = 0; i < n; i++)
                    out.append(s.charAt(i) == '0' ? -INF : a[i]).append(" ");
                out.append("\n");
                continue;
            }

            // Step 2: prefix (max subarray ending at i)
            long[] pref = new long[n];
            curr = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    curr = Math.max(a[i], curr + a[i]);
                    pref[i] = curr;
                } else {
                    curr = 0;
                    pref[i] = 0;
                }
            }

            // Step 3: suffix (max subarray starting at i)
            long[] suff = new long[n];
            curr = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '1') {
                    curr = Math.max(a[i], curr + a[i]);
                    suff[i] = curr;
                } else {
                    curr = 0;
                    suff[i] = 0;
                }
            }

            boolean built = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    long left = (i > 0 ? Math.max(0, pref[i - 1]) : 0);
                    long right = (i + 1 < n ? Math.max(0, suff[i + 1]) : 0);

                    if (left + right <= k) {
                        a[i] = k - left - right;
                        for (int j = 0; j < n; j++)
                            if (s.charAt(j) == '0' && j != i) a[j] = -INF;
                        built = true;
                        break;
                    }
                }
            }

            if (!built) {
                out.append("No\n");
                continue;
            }

            out.append("Yes\n");
            for (long x : a) out.append(x).append(" ");
            out.append("\n");
        }

        System.out.print(out);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
