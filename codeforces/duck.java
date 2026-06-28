import java.util.Scanner;
public class duck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()){
            return;
        }

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            long maxRequired = 0;
            long prefixSum = 0;
            
            for (int i = 1; i <= n; i++) {
                long val = sc.nextLong();
                prefixSum += val;
                
                long currentCeil = (prefixSum + i - 1) / i;
                if (currentCeil > maxRequired) {
                    maxRequired = currentCeil;
                }
            }   
            sb.append(maxRequired).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}
