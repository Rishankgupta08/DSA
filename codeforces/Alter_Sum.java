import java.util.*;

public class Alter_Sum {
    static final int MOD = 1_000_000_007;
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) != 0) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = 0;
            List<Integer> distinct = new ArrayList<>();
            List<Integer> freq = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val == -1) {
                    c++;
                } else {
                    if (distinct.isEmpty() || distinct.get(distinct.size() - 1) != val) {
                        distinct.add(val);
                        freq.add(1);
                    } else {
                        int lastIdx = freq.size() - 1;
                        freq.set(lastIdx, freq.get(lastIdx) + 1);
                    }
                }
            }
            long E = 1;
            for (int f : freq) {
                E = (E * power(2, f - 1)) % MOD;
            }
            long K = 0;
            for (int i = 0; i < distinct.size() - 1; i++) {
                if (distinct.get(i + 1) - distinct.get(i) == 1) {
                    K++;
                }
            }
            long ans = 0;
            if (c == 0) {
                ans = E;
            } else {
                ans = (power(2, c - 1) * E) % MOD;
                ans = (ans * (K + 1)) % MOD;
            }
            
            out.append(ans).append("\n");
        }
        System.out.print(out);
        sc.close();
    }
}