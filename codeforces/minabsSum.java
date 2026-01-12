import java.util.Arrays;
import java.util.Scanner;
public class minabsSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int first = a[0];
            int last  = a[n - 1];

            int ans;
            if (first != -1 && last != -1) {
                ans = Math.abs(last - first);
            } else {
                ans = 0;
            }

            int[] res = Arrays.copyOf(a, n);
            if (first == -1 && last == -1) {
                res[0] = 0;
                res[n - 1] = 0;
            } 
            else if (first == -1) {
                res[0] = last;     
            } 
            else if (last == -1) {
                res[n - 1] = first;   
            }
            for (int i = 0; i < n; i++) {
                if (res[i] == -1) res[i] = 0;
            }

            System.out.println(ans);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + (i+1<n ? " " : ""));
            }
            System.out.println();
        }
        sc.close();
    }
}
