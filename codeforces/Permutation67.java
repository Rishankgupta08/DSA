import java.util.Scanner;
public class Permutation67 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--> 0) {
            int n=sc.nextInt();
            StringBuilder sb=new StringBuilder();
            int l=1;    
            int r=3*n;  
            for (int i=0;i<n;i++) {
                sb.append(l).append(" ");
                sb.append(r).append(" ");
                sb.append(r-1).append(" ");
                l++;
                r-=2;
            }
            System.out.println(sb.toString().trim());
        }
    }
}