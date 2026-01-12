import java.util.Scanner;
public class Fibonaccharsis{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            long n=sc.nextLong();
            long k=sc.nextLong();
            int ans=fib(n,k);
            System.out.println(ans);
        }
    }
    public static int fib(long n,long k){
        int count=0;
        
        for(long i = 0 ; i <=n ; i++){
            long second = n;   // kth term
            long first = i;    // (k-1)th term

            boolean isValid=true;
            for(long j=k-2;j>=1;j--){ 
                long newE = second - first;

                if (newE < 0) {
                    isValid = false;
                    break;
                }
                else if (newE > first) {
                    isValid = false;
                    break;
                }
                else {
                    // update sequence
                    second = first;
                    first = newE;

            }
        }
         if (isValid) {
                count++;
            }
        }

        return count;

    }

}