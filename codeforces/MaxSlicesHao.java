import java.util.Scanner;

public class MaxSlicesHao {
    public static long maxSlices(long n) {
        long total = 0;
        while (n > 2) {
            long m1 = n / 3;
            long m2 = m1;
            long m3 = n - m1 - m2;
            total += m1;
            n = m3;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(maxSlices(n));
        }

        sc.close();
    }
}
