import java.util.Scanner;

public class Storming {
    static final int LIMIT = 1000000;
    static int[] primes = new int[LIMIT + 1];
    public static void generateSPF() {
        for(int i=0;i<=LIMIT;i++) {
            primes[i] = i;
        }
        for(int i=2;i*i<=LIMIT;i++) {
            if(primes[i]!=i)continue;
            for(int j=i*i;j<=LIMIT;j+=i) {
                if(primes[j]==j) {
                    primes[j] = i;
                }
            }
        }
    }
    public static int findAnswer(int n) {
        int eSum=0;
        int dPrime=0;
        while(n>1) {
            int factor=primes[n];
            dPrime++;
            do {
                eSum++;
                n/=factor;
            }while (n>1 && n % factor == 0);
        }
        return eSum+dPrime-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        generateSPF();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(findAnswer(n));
        }
    }
}