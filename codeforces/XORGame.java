import java.util.Scanner;
public class XORGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }

            for(int i=0;i<n;i++){
                if((i+1)%2==0){
                    if(a[i] == 1 && b[i] == 0){
		                b[i] = 1;
		                a[i] = 0;
		            }
		        }else{
		            if(b[i] == 1 && a[i] == 0){
		                b[i] = 0;
		                a[i] = 1;
		            }
                }
            }
            int ans1=0;
            int ans2=0;
            for(int i=0;i<n;i++){
                ans1^=a[i];
            }
            for(int i=0;i<n;i++){
                ans2^=b[i];
            }
            if(ans1>ans2){
                System.out.println("Ajisai");
            }else if(ans1<ans2){
                System.out.println("Mai");
            }else{
                System.out.println("Tie");
            }
        }
        sc.close();
    }
}