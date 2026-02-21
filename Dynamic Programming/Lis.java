import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Lis{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> res=new ArrayList<>();
        int[] dp=new int[n];
        int [] parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int maxi=1;
        int lastidx=0;
        for(int curr=1;curr<n;curr++){
            for(int prev=0;prev<curr;prev++){
                if(arr[curr]>arr[prev] && dp[curr]<dp[prev]+1){
                    dp[curr]=dp[prev]+1;
                    maxi=Math.max(dp[curr],maxi);
                    parent[curr]=prev;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                lastidx=i;
                break;
            }
        }
        for(int i=lastidx;i!=-1;i=parent[i]){
            res.add(arr[i]);
        }
        Collections.reverse(res);
        System.out.println(dp[n-1]);
        System.out.println(res);
    }
}