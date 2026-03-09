import java.util.Scanner;

public class ParkourDesign{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int x=sc.nextInt();
            int y=sc.nextInt();

           int eqn=x-(2*y);
           if(eqn <0 || eqn %3!=0){
            System.out.println("No");
                continue;
           }
           int ans=eqn/3;
           int min=Math.max(0,-y);
           if(2*min > ans){
                System.out.println("No");
           }else{
                System.out.println("Yes");
           }
        }
    }
}