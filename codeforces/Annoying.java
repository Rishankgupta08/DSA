import java.util.*;
import java.io.*;

public class Annoying {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            ArrayList<Long> a = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                long ele = sc.nextLong();
                a.add(ele);
            }
            
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }
            
            long swap = 0;
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                int idx = -1;
                long val = b[j];
                
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) <= val) {
                        idx = i;
                        break;
                    }
                }
                
                if (idx == -1) {
                    possible = false;
                    break;
                }

                swap += idx;
                a.remove(idx);
            }
            
            if (possible) {
                sb.append(swap).append("\n");
            } else {
                sb.append("-1").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}