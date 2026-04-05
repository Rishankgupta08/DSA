package HWI;

import java.util.Scanner;

class StableTemp{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int cost=0;
        for(int i=n-2;i>=0;i--){
            if((arr[i]-arr[i+1])>=1){
                cost+=(arr[i]-(arr[i+1]+1));
                arr[i]=arr[i+1]+1;
            }
        }
        for(int i=1;i<n;i++){
            if((arr[i]-arr[i-1])>=1){
                cost+=(arr[i]-(arr[i-1]+1));
                arr[i]=arr[i-1]+1;
            }
        }
        System.out.println(cost);
    }
}