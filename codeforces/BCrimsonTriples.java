import java.util.Scanner;

public class BCrimsonTriples{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            long ans=0;
            for(int i=1;i<=n;i++){
                long count=n/i;
                ans+=count*count;
            }
            System.out.println(ans);
        }
    }
}