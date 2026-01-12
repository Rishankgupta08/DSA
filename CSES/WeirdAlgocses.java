import java.util.Scanner;

public class WeirdAlgocses {
    public static void algo(long n) {
        
        if(n==1){
            System.out.print(1);
            return;
        }
        System.out.print(n + " ");
        if(n%2==0){
            algo(n/2);
        
        } else {
            algo(3*n+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        algo(n);

        sc.close();
    }
}
