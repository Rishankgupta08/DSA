import java.util.Scanner;
class BePositive2149{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int zeros = 0;
            int neg = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == 0) zeros++;
                else if (x == -1) neg++;
            }
            int ops = zeros + (neg % 2 == 1 ? 2 : 0);
            System.out.println(ops);
        }
        sc.close();
    }
}