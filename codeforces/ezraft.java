import java.util.Scanner;

public class ezraft{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            if(n==1){
                System.out.println(1);
                continue;
            }
            if(n==2){
                System.out.println(-1);
                continue;
            }
                System.out.print("1 2");
                long next=3;
                for(int i=3;i<=n;i++){
                    System.out.print(" "+next);
                    next*=2;
                }
                System.out.println();
        }
    }
}