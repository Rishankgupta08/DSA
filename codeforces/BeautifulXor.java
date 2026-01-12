import java.util.*;
public class BeautifulXor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == b) {
                System.out.println(0);
            }else if ((a ^ b) <= a) {
                System.out.println(1);
                System.out.println(a ^ b);
            } else {
                long a1 = a ^ 1;
                long x2 = a1 ^ b;
                if (x2 <= a1) {
                    System.out.println(2);
                    System.out.println(1 + " " + x2);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}
