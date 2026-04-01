package HWI;

import java.util.Scanner;

public class Threshold1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int k=sc.nextInt();

        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=1;i<n;i++){
            if(arr[i]+x<arr[i+1]){
                if(k==0){
                    System.out.println(i);
                    return;
                }else{
                    k--;
                }
            }
        }
        System.out.println(n);
    }
}
