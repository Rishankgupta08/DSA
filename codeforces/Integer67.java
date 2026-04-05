import java.util.Scanner;

public class Integer67{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            if(n==67){
                System.out.println(67);
                continue;
            }
            System.out.println(n+1);
        }
    }
}