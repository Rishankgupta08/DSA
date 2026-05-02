package HWI;

import java.util.Scanner;

public class Vineyard{
    static int n;
    static int m;
    static int[] prefMinA;
    static int[] prefMinB;
    static int[] prefMaxA;
    static int[] prefMaxB;
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

        prefMinA=new int[n];
        prefMaxA=new int[n];
        prefMinB=new int[m];
        prefMaxB=new int[m];
        prefMaxA[0]=A[0];
        prefMinA[0]=A[0];
        for(int i=1;i<n;i++){
            prefMaxA[i]=Math.max(prefMaxA[i-1],A[i]);
            prefMinA[i]=Math.min(prefMinA[i-1],A[i]);
        }
        prefMaxB[0]=B[0];
        prefMinB[0]=B[0];
        for(int i=1;i<m;i++){
            prefMaxB[i]=Math.max(prefMaxB[i-1],A[i]);
            prefMinB[i]=Math.min(prefMinB[i-1],A[i]);
        }
        int ans=solve(0,0,A,B);
        System.out.println(ans);
    }
    public static int solve(int i,int j,int[] A,int[] B){
        if(i==n && j==m) return 0;

        boolean isFirst=(i+j==0);
        int best=Integer.MIN_VALUE;
        if(i<n){
            int cost=(isFirst)?0: Math.max(Math.abs(A[i]-prefMaxA[i]),Math.abs(A[i]-prefMinA[i]));

            int newMin=isFirst?A[i]:Math.min(prefMinA[i], A[i]);
            int newMax=isFirst?A[i]:Math.max(prefMaxA[i], A[i]);
            best=Math.max(best,cost+solve(i+1,j,A,B));
        }

        if(j<m){
            int cost=(isFirst)?0: Math.max(Math.abs(B[j]-prefMaxB[j]),Math.abs(B[j]-prefMinB[j]));

            int newMin=isFirst?B[j]:Math.min(prefMaxB[j], B[j]);
            int newMax=isFirst?B[j]:Math.max(prefMaxB[j], B[j]);
            best=Math.max(best,cost+solve(i,j+1,A,B));
        }
        return best;
    }
}