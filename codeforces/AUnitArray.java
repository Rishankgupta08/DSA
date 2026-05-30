import java.util.Scanner;

public class AUnitArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int pos = 0;
            int neg = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == 1) {
                    pos++;
                } else {
                    neg++;
                }
            }
            int ops = 0;
            while (neg > pos) {
                neg--;
                pos++;
                ops++;
            }
            if (neg % 2 != 0) {
                ops++;
            }
            
            System.out.println(ops);
            
        }
    }
}