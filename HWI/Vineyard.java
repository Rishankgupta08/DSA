package HWI;

import java.util.Scanner;

public class Vineyard{
    static int n;
    static int m;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        int[] A=new int[n];
        int[] B=new int[m];

        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            B[i]=sc.nextInt();
        }
        int ans=solve(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,A,B);
        System.out.println(ans);
    }
    public static int solve(int i,int j,int max,int min,int[] A,int[] B){
        if(i==n && j==m) return 0;

        boolean isFirst=(i+j==0);
        int best=Integer.MIN_VALUE;
        if(i<n){
            int cost=(isFirst)?0: Math.max(Math.abs(A[i]-max),Math.abs(A[i]-min));

            int newMin=isFirst?A[i]:Math.min(min, A[i]);
            int newMax=isFirst?A[i]:Math.max(max, A[i]);
            best=Math.max(best,cost+solve(i+1,j,newMin,newMax,A,B));
        }

        if(j<m){
            int cost=(isFirst)?0: Math.max(Math.abs(B[j]-max),Math.abs(B[j]-min));

            int newMin=isFirst?B[j]:Math.min(min, B[j]);
            int newMax=isFirst?B[j]:Math.max(max, B[j]);
            best=Math.max(best,cost+solve(i,j+1,newMin,newMax,A,B));
        }
        return best;
    }
}