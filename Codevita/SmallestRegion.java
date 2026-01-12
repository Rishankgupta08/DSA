import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SmallestRegion{

    public static boolean f1(char a1, int b2, List<int[]> c3) {
        for (int[] d4 : c3) {
            int e5 = d4[0], f6 = d4[1], g7 = d4[2], h8 = d4[3];
            if (a1 == 'x' && e5 < b2 && b2 < g7) return false;
            if (a1 == 'y' && f6 < b2 && b2 < h8) return false;
        }
        return true;
    }

    public static int f2(List<int[]> i9, int[] j0) {
        int k1 = j0[0], l2 = j0[1], m3 = j0[2], n4 = j0[3];
        List<Integer> o5 = new ArrayList<>();
        List<Integer> p6 = new ArrayList<>();
        
        for (int q7 = k1 + 1; q7 < m3; ++q7) {
            if (f1('x', q7, i9)) o5.add(q7);
        }
        for (int r8 = l2 + 1; r8 < n4; ++r8) {
            if (f1('y', r8, i9)) p6.add(r8);
        }
        
        List<Integer> s9 = new ArrayList<>();
        s9.add(k1);
        s9.addAll(o5);
        s9.add(m3);
        
        List<Integer> t0 = new ArrayList<>();
        t0.add(l2);
        t0.addAll(p6);
        t0.add(n4);
        
        int u1 = (m3 - k1) * (n4 - l2);
        for (int v2 = 1; v2 < s9.size(); ++v2) {
            for (int w3 = 1; w3 < t0.size(); ++w3) {
                int x4 = (s9.get(v2) - s9.get(v2 - 1)) * (t0.get(w3) - t0.get(w3 - 1));
                u1 = Math.min(u1, x4);
            }
        }
        return u1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        int y5 = Integer.parseInt(br.readLine());
        List<int[]> z6 = new ArrayList<>(y5);
        for (int a7 = 0; a7 < y5; ++a7) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            arr[3] = Integer.parseInt(st.nextToken());
            z6.add(arr);
        }
        
        int[] b8 = new int[4];
        st = new StringTokenizer(br.readLine());
        b8[0] = Integer.parseInt(st.nextToken());
        b8[1] = Integer.parseInt(st.nextToken());
        b8[2] = Integer.parseInt(st.nextToken());
        b8[3] = Integer.parseInt(st.nextToken());
        
        out.println(f2(z6, b8));
        
        out.close();
        br.close();
    }
}