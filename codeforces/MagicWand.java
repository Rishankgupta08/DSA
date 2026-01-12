import java.util.Scanner;
import java.util.Arrays;

public class MagicWand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean hasEven = false, hasOdd = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] % 2 == 0) hasEven = true;
                else hasOdd = true;
            }

            // If both parities exist, we can fully sort it
            if (hasEven && hasOdd) {
                Arrays.sort(a);
            }

            for (int x : a) System.out.print(x + " ");
            System.out.println();
        }

        sc.close();
    }
}
