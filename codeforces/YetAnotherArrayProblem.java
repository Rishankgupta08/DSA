import java.util.*;
public class YetAnotherArrayProblem{
    public static long gcd(long a , long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t--> 0){
		    int n = sc.nextInt();
		    long[] arr = new long[n];
		    
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long g = arr[0];
            for(int i = 1 ; i < n ; i++){
                g = gcd(g,arr[i]); 
            }
            if(g==1) {
                System.out.println(2);
                continue;
            }
            Set<Long> prime = primeFactors(g); 
            int ans = -1;
            for (int x = 2; x <= 100; x++) { 
                boolean check = true;
                for (long p : prime) {
                    if (x % p == 0) {
                        check = false;
                        break;
                    }
                }
                if(check){
                    ans = x;
                    break;
                }
            }System.out.println(ans);
        }sc.close();
    }
    public static Set<Long> primeFactors(long n) {
        Set<Long> set = new HashSet<>();
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if(n > 1){
            set.add(n); 
        }return set;
    }
}