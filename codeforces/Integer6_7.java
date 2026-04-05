import java.util.Scanner;

public class Integer6_7{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int idx=0;
        while(t-- >0){
            int[] arr=new int[7];
            int max=Integer.MIN_VALUE;
            for(int i=0;i<7;i++){
                arr[i]=sc.nextInt();
                if(arr[i]>max){
                    max=arr[i];
                    idx=i;
                }

            }
            int sum=max;
            for(int i=0;i<7;i++){
                if(idx==i) continue;
                sum-=arr[i];
            }
            System.out.println(sum);
        }
    }
}