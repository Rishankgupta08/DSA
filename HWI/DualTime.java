package HWI;
import java.util.Scanner;
class DualTime{
    static int n;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] D=new int[n];
        int[] P=new int[n];
        int maxTime=0;
        for(int i=0;i<n;i++){
            D[i]=sc.nextInt();
            maxTime+=D[i];
        }
        for(int i=0;i<n;i++){
            P[i]=sc.nextInt();
        }
        Integer[][] dp=new Integer[n][maxTime+1];
        int ans=solve(0,0,0,D,P,dp);
        System.out.println(ans);
    }
    public static int solve(int idx,int A,int B,int[] D,int[] P,Integer[][] dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][A]!=null){
            return dp[idx][A];
        }
        int newA=A+D[idx];
        int newP=newA*P[idx];
        int costA=newP+solve(idx+1,newA,B,D,P,dp);
        int newB=B+D[idx];
        int newPB=newB*P[idx];
        int costB=newPB+solve(idx+1,A,newB,D,P,dp);
        return dp[idx][A]=Math.min(costA,costB);
    }
}