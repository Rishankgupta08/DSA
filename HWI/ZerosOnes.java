package HWI;

import java.util.Scanner;

public class ZerosOnes {
    static int MOD=1_000_000_007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] B=new int[m+1];
        int[] A=new int[n+1];
        for(int i=1;i<=m;i++){
            B[i]=sc.nextInt();
        }
        int totalCost=0;

        for(int i=1;i<=m;i++){
            if(A[B[i]]==0){
                A[B[i]]=1;
                totalCost*=calculateCost(A);
            }else{
                A[B[i]]=0;
                totalCost*=calculateCost(A);
            }
        }
        System.out.println(totalCost % MOD);
    }
    public static int calculateCost(int[] arr){
        int n=arr.length;
        return 2;
    }
}
