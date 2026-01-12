import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            List<Integer> zeros = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') zeros.add(i + 1); 
            }
            out.append(zeros.size()).append('\n');
            if (zeros.size() == 0) {
                out.append('\n'); 
            } else {
                for (int i = 0; i < zeros.size(); i++) {
                    if (i > 0) out.append(' ');
                    out.append(zeros.get(i));
                }
                out.append('\n');
            }
        }
        System.out.print(out.toString());
    }
}