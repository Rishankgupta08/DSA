import java.util.Arrays;
import java.util.Scanner;

public class AnotherPuzzle{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int c=sc.nextInt();
            int[] arr1=new int[n];
            int[] arr2=new int[n];
            int sum1=0;
            int sum2=0;
            for(int i=0;i<n;i++){
                arr1[i]=sc.nextInt();
                sum1+=arr1[i];
            }
            for(int i=0;i<n;i++){
                arr2[i]=sc.nextInt();
                sum2+=arr2[i];
            }
            if(sum1<sum2){
                System.out.println("-1");
                continue;
            }
            int diff=sum1-sum2;
            int ans=Integer.MAX_VALUE;
            boolean check=true;
            for(int i=0;i<n;i++){
                if(arr1[i]<arr2[i]){
                    check=false;
                    break;
                }
            }
            if(check) ans=diff;
            int[] a1=arr1.clone();
            int[] a2=arr2.clone();
            Arrays.sort(a1);
            Arrays.sort(a2);
            check=true;
            for(int i=0;i<n;i++){
                if(a1[i]<a2[i]){
                    check=false;
                    break;
                }
            }
            if(check){
                ans=Math.min(ans,diff+c);
            }
            if(ans==Integer.MAX_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(ans);
            }
        }
    }
}